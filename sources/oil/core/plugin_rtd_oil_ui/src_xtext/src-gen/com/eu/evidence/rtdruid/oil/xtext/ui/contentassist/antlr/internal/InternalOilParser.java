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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ZERO_INT", "RULE_HEX", "RULE_NON_ZERO_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INCLUDE", "RULE_WS", "RULE_ANY_OTHER", "'STRING'", "'UINT32'", "'INT32'", "'UINT64'", "'INT64'", "'FLOAT'", "'BOOLEAN'", "'ENUM'", "'OS'", "'ALARM'", "'APPMODE'", "'COUNTER'", "'COM'", "'EVENT'", "'IPDU'", "'ISR'", "'MESSAGE'", "'NETWORKMESSAGE'", "'NM'", "'RESOURCE'", "'TASK'", "'SPINLOCK'", "'SCHEDULETABLE'", "'OS_TYPE'", "'ALARM_TYPE'", "'APPMODE_TYPE'", "'COUNTER_TYPE'", "'COM_TYPE'", "'EVENT_TYPE'", "'IPDU_TYPE'", "'ISR_TYPE'", "'MESSAGE_TYPE'", "'NETWORKMESSAGE_TYPE'", "'NM_TYPE'", "'RESOURCE_TYPE'", "'TASK_TYPE'", "'SPINLOCK_TYPE'", "'SCHEDULETABLE_TYPE'", "'+'", "'-'", "'APPLICATION'", "'APPLICATION_TYPE'", "'OIL_VERSION'", "'='", "';'", "'IMPLEMENTATION'", "'{'", "'}'", "':'", "'CPU'", "','", "'..'", "'['", "']'", "'.'", "'WITH_AUTO'", "'[]'", "'AUTO'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
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
    public static final int RULE_ANY_OTHER=13;
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
            case 50:
            case 51:
            case 55:
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

            if ( (LA3_0==71) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=RULE_ID && LA3_0<=RULE_NON_ZERO_INT)||(LA3_0>=52 && LA3_0<=53)) ) {
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

            if ( ((LA4_0>=RULE_STRING && LA4_0<=RULE_NON_ZERO_INT)||(LA4_0>=52 && LA4_0<=53)) ) {
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

            if ( (LA5_0==71) ) {
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

            if ( (LA6_0==71) ) {
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
            case 71:
                {
                alt7=1;
                }
                break;
            case RULE_STRING:
            case RULE_ZERO_INT:
            case RULE_HEX:
            case RULE_NON_ZERO_INT:
            case 52:
            case 53:
                {
                alt7=2;
                }
                break;
            case RULE_ID:
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
            case 48:
            case 49:
            case 50:
            case 51:
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:835:1: rule__SpecialId__Alternatives : ( ( RULE_ID ) | ( 'STRING' ) | ( 'UINT32' ) | ( 'INT32' ) | ( 'UINT64' ) | ( 'INT64' ) | ( 'FLOAT' ) | ( 'BOOLEAN' ) | ( 'ENUM' ) | ( 'OS' ) | ( 'ALARM' ) | ( 'APPMODE' ) | ( 'COUNTER' ) | ( 'COM' ) | ( 'EVENT' ) | ( 'IPDU' ) | ( 'ISR' ) | ( 'MESSAGE' ) | ( 'NETWORKMESSAGE' ) | ( 'NM' ) | ( 'RESOURCE' ) | ( 'TASK' ) | ( 'SPINLOCK' ) | ( 'SCHEDULETABLE' ) | ( 'OS_TYPE' ) | ( 'ALARM_TYPE' ) | ( 'APPMODE_TYPE' ) | ( 'COUNTER_TYPE' ) | ( 'COM_TYPE' ) | ( 'EVENT_TYPE' ) | ( 'IPDU_TYPE' ) | ( 'ISR_TYPE' ) | ( 'MESSAGE_TYPE' ) | ( 'NETWORKMESSAGE_TYPE' ) | ( 'NM_TYPE' ) | ( 'RESOURCE_TYPE' ) | ( 'TASK_TYPE' ) | ( 'SPINLOCK_TYPE' ) | ( 'SCHEDULETABLE_TYPE' ) );
    public final void rule__SpecialId__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:839:1: ( ( RULE_ID ) | ( 'STRING' ) | ( 'UINT32' ) | ( 'INT32' ) | ( 'UINT64' ) | ( 'INT64' ) | ( 'FLOAT' ) | ( 'BOOLEAN' ) | ( 'ENUM' ) | ( 'OS' ) | ( 'ALARM' ) | ( 'APPMODE' ) | ( 'COUNTER' ) | ( 'COM' ) | ( 'EVENT' ) | ( 'IPDU' ) | ( 'ISR' ) | ( 'MESSAGE' ) | ( 'NETWORKMESSAGE' ) | ( 'NM' ) | ( 'RESOURCE' ) | ( 'TASK' ) | ( 'SPINLOCK' ) | ( 'SCHEDULETABLE' ) | ( 'OS_TYPE' ) | ( 'ALARM_TYPE' ) | ( 'APPMODE_TYPE' ) | ( 'COUNTER_TYPE' ) | ( 'COM_TYPE' ) | ( 'EVENT_TYPE' ) | ( 'IPDU_TYPE' ) | ( 'ISR_TYPE' ) | ( 'MESSAGE_TYPE' ) | ( 'NETWORKMESSAGE_TYPE' ) | ( 'NM_TYPE' ) | ( 'RESOURCE_TYPE' ) | ( 'TASK_TYPE' ) | ( 'SPINLOCK_TYPE' ) | ( 'SCHEDULETABLE_TYPE' ) )
            int alt8=39;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt8=1;
                }
                break;
            case 14:
                {
                alt8=2;
                }
                break;
            case 15:
                {
                alt8=3;
                }
                break;
            case 16:
                {
                alt8=4;
                }
                break;
            case 17:
                {
                alt8=5;
                }
                break;
            case 18:
                {
                alt8=6;
                }
                break;
            case 19:
                {
                alt8=7;
                }
                break;
            case 20:
                {
                alt8=8;
                }
                break;
            case 21:
                {
                alt8=9;
                }
                break;
            case 22:
                {
                alt8=10;
                }
                break;
            case 23:
                {
                alt8=11;
                }
                break;
            case 24:
                {
                alt8=12;
                }
                break;
            case 25:
                {
                alt8=13;
                }
                break;
            case 26:
                {
                alt8=14;
                }
                break;
            case 27:
                {
                alt8=15;
                }
                break;
            case 28:
                {
                alt8=16;
                }
                break;
            case 29:
                {
                alt8=17;
                }
                break;
            case 30:
                {
                alt8=18;
                }
                break;
            case 31:
                {
                alt8=19;
                }
                break;
            case 32:
                {
                alt8=20;
                }
                break;
            case 33:
                {
                alt8=21;
                }
                break;
            case 34:
                {
                alt8=22;
                }
                break;
            case 35:
                {
                alt8=23;
                }
                break;
            case 36:
                {
                alt8=24;
                }
                break;
            case 37:
                {
                alt8=25;
                }
                break;
            case 38:
                {
                alt8=26;
                }
                break;
            case 39:
                {
                alt8=27;
                }
                break;
            case 40:
                {
                alt8=28;
                }
                break;
            case 41:
                {
                alt8=29;
                }
                break;
            case 42:
                {
                alt8=30;
                }
                break;
            case 43:
                {
                alt8=31;
                }
                break;
            case 44:
                {
                alt8=32;
                }
                break;
            case 45:
                {
                alt8=33;
                }
                break;
            case 46:
                {
                alt8=34;
                }
                break;
            case 47:
                {
                alt8=35;
                }
                break;
            case 48:
                {
                alt8=36;
                }
                break;
            case 49:
                {
                alt8=37;
                }
                break;
            case 50:
                {
                alt8=38;
                }
                break;
            case 51:
                {
                alt8=39;
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
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__SpecialId__Alternatives1764); if (state.failed) return ;
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
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__SpecialId__Alternatives1784); if (state.failed) return ;
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
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__SpecialId__Alternatives1804); if (state.failed) return ;
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
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__SpecialId__Alternatives1824); if (state.failed) return ;
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
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__SpecialId__Alternatives1844); if (state.failed) return ;
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
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__SpecialId__Alternatives1864); if (state.failed) return ;
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
                    match(input,20,FollowSets000.FOLLOW_20_in_rule__SpecialId__Alternatives1884); if (state.failed) return ;
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
                    match(input,21,FollowSets000.FOLLOW_21_in_rule__SpecialId__Alternatives1904); if (state.failed) return ;
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
                    match(input,22,FollowSets000.FOLLOW_22_in_rule__SpecialId__Alternatives1924); if (state.failed) return ;
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
                    match(input,23,FollowSets000.FOLLOW_23_in_rule__SpecialId__Alternatives1944); if (state.failed) return ;
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
                    match(input,24,FollowSets000.FOLLOW_24_in_rule__SpecialId__Alternatives1964); if (state.failed) return ;
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
                    match(input,25,FollowSets000.FOLLOW_25_in_rule__SpecialId__Alternatives1984); if (state.failed) return ;
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
                    match(input,26,FollowSets000.FOLLOW_26_in_rule__SpecialId__Alternatives2004); if (state.failed) return ;
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
                    match(input,27,FollowSets000.FOLLOW_27_in_rule__SpecialId__Alternatives2024); if (state.failed) return ;
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
                    match(input,28,FollowSets000.FOLLOW_28_in_rule__SpecialId__Alternatives2044); if (state.failed) return ;
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
                    match(input,29,FollowSets000.FOLLOW_29_in_rule__SpecialId__Alternatives2064); if (state.failed) return ;
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
                    match(input,30,FollowSets000.FOLLOW_30_in_rule__SpecialId__Alternatives2084); if (state.failed) return ;
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
                    match(input,31,FollowSets000.FOLLOW_31_in_rule__SpecialId__Alternatives2104); if (state.failed) return ;
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
                    match(input,32,FollowSets000.FOLLOW_32_in_rule__SpecialId__Alternatives2124); if (state.failed) return ;
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
                    match(input,33,FollowSets000.FOLLOW_33_in_rule__SpecialId__Alternatives2144); if (state.failed) return ;
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
                    match(input,34,FollowSets000.FOLLOW_34_in_rule__SpecialId__Alternatives2164); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getTASKKeyword_21()); 
                    }

                    }


                    }
                    break;
                case 23 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1014:6: ( 'SPINLOCK' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1014:6: ( 'SPINLOCK' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1015:1: 'SPINLOCK'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getSPINLOCKKeyword_22()); 
                    }
                    match(input,35,FollowSets000.FOLLOW_35_in_rule__SpecialId__Alternatives2184); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getSPINLOCKKeyword_22()); 
                    }

                    }


                    }
                    break;
                case 24 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1022:6: ( 'SCHEDULETABLE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1022:6: ( 'SCHEDULETABLE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1023:1: 'SCHEDULETABLE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getSCHEDULETABLEKeyword_23()); 
                    }
                    match(input,36,FollowSets000.FOLLOW_36_in_rule__SpecialId__Alternatives2204); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getSCHEDULETABLEKeyword_23()); 
                    }

                    }


                    }
                    break;
                case 25 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1030:6: ( 'OS_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1030:6: ( 'OS_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1031:1: 'OS_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getOS_TYPEKeyword_24()); 
                    }
                    match(input,37,FollowSets000.FOLLOW_37_in_rule__SpecialId__Alternatives2224); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getOS_TYPEKeyword_24()); 
                    }

                    }


                    }
                    break;
                case 26 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1038:6: ( 'ALARM_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1038:6: ( 'ALARM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1039:1: 'ALARM_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getALARM_TYPEKeyword_25()); 
                    }
                    match(input,38,FollowSets000.FOLLOW_38_in_rule__SpecialId__Alternatives2244); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getALARM_TYPEKeyword_25()); 
                    }

                    }


                    }
                    break;
                case 27 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1046:6: ( 'APPMODE_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1046:6: ( 'APPMODE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1047:1: 'APPMODE_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getAPPMODE_TYPEKeyword_26()); 
                    }
                    match(input,39,FollowSets000.FOLLOW_39_in_rule__SpecialId__Alternatives2264); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getAPPMODE_TYPEKeyword_26()); 
                    }

                    }


                    }
                    break;
                case 28 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1054:6: ( 'COUNTER_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1054:6: ( 'COUNTER_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1055:1: 'COUNTER_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getCOUNTER_TYPEKeyword_27()); 
                    }
                    match(input,40,FollowSets000.FOLLOW_40_in_rule__SpecialId__Alternatives2284); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getCOUNTER_TYPEKeyword_27()); 
                    }

                    }


                    }
                    break;
                case 29 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1062:6: ( 'COM_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1062:6: ( 'COM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1063:1: 'COM_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getCOM_TYPEKeyword_28()); 
                    }
                    match(input,41,FollowSets000.FOLLOW_41_in_rule__SpecialId__Alternatives2304); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getCOM_TYPEKeyword_28()); 
                    }

                    }


                    }
                    break;
                case 30 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1070:6: ( 'EVENT_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1070:6: ( 'EVENT_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1071:1: 'EVENT_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getEVENT_TYPEKeyword_29()); 
                    }
                    match(input,42,FollowSets000.FOLLOW_42_in_rule__SpecialId__Alternatives2324); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getEVENT_TYPEKeyword_29()); 
                    }

                    }


                    }
                    break;
                case 31 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1078:6: ( 'IPDU_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1078:6: ( 'IPDU_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1079:1: 'IPDU_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getIPDU_TYPEKeyword_30()); 
                    }
                    match(input,43,FollowSets000.FOLLOW_43_in_rule__SpecialId__Alternatives2344); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getIPDU_TYPEKeyword_30()); 
                    }

                    }


                    }
                    break;
                case 32 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1086:6: ( 'ISR_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1086:6: ( 'ISR_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1087:1: 'ISR_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getISR_TYPEKeyword_31()); 
                    }
                    match(input,44,FollowSets000.FOLLOW_44_in_rule__SpecialId__Alternatives2364); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getISR_TYPEKeyword_31()); 
                    }

                    }


                    }
                    break;
                case 33 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1094:6: ( 'MESSAGE_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1094:6: ( 'MESSAGE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1095:1: 'MESSAGE_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getMESSAGE_TYPEKeyword_32()); 
                    }
                    match(input,45,FollowSets000.FOLLOW_45_in_rule__SpecialId__Alternatives2384); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getMESSAGE_TYPEKeyword_32()); 
                    }

                    }


                    }
                    break;
                case 34 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1102:6: ( 'NETWORKMESSAGE_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1102:6: ( 'NETWORKMESSAGE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1103:1: 'NETWORKMESSAGE_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getNETWORKMESSAGE_TYPEKeyword_33()); 
                    }
                    match(input,46,FollowSets000.FOLLOW_46_in_rule__SpecialId__Alternatives2404); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getNETWORKMESSAGE_TYPEKeyword_33()); 
                    }

                    }


                    }
                    break;
                case 35 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1110:6: ( 'NM_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1110:6: ( 'NM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1111:1: 'NM_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getNM_TYPEKeyword_34()); 
                    }
                    match(input,47,FollowSets000.FOLLOW_47_in_rule__SpecialId__Alternatives2424); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getNM_TYPEKeyword_34()); 
                    }

                    }


                    }
                    break;
                case 36 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1118:6: ( 'RESOURCE_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1118:6: ( 'RESOURCE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1119:1: 'RESOURCE_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getRESOURCE_TYPEKeyword_35()); 
                    }
                    match(input,48,FollowSets000.FOLLOW_48_in_rule__SpecialId__Alternatives2444); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getRESOURCE_TYPEKeyword_35()); 
                    }

                    }


                    }
                    break;
                case 37 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1126:6: ( 'TASK_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1126:6: ( 'TASK_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1127:1: 'TASK_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getTASK_TYPEKeyword_36()); 
                    }
                    match(input,49,FollowSets000.FOLLOW_49_in_rule__SpecialId__Alternatives2464); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getTASK_TYPEKeyword_36()); 
                    }

                    }


                    }
                    break;
                case 38 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1134:6: ( 'SPINLOCK_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1134:6: ( 'SPINLOCK_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1135:1: 'SPINLOCK_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getSPINLOCK_TYPEKeyword_37()); 
                    }
                    match(input,50,FollowSets000.FOLLOW_50_in_rule__SpecialId__Alternatives2484); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getSPINLOCK_TYPEKeyword_37()); 
                    }

                    }


                    }
                    break;
                case 39 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1142:6: ( 'SCHEDULETABLE_TYPE' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1142:6: ( 'SCHEDULETABLE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1143:1: 'SCHEDULETABLE_TYPE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSpecialIdAccess().getSCHEDULETABLE_TYPEKeyword_38()); 
                    }
                    match(input,51,FollowSets000.FOLLOW_51_in_rule__SpecialId__Alternatives2504); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSpecialIdAccess().getSCHEDULETABLE_TYPEKeyword_38()); 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1155:1: rule__GenericValue__Alternatives : ( ( RULE_STRING ) | ( ruleINT ) | ( ruleFLOAT ) );
    public final void rule__GenericValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1159:1: ( ( RULE_STRING ) | ( ruleINT ) | ( ruleFLOAT ) )
            int alt9=3;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1160:1: ( RULE_STRING )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1160:1: ( RULE_STRING )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1161:1: RULE_STRING
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericValueAccess().getSTRINGTerminalRuleCall_0()); 
                    }
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__GenericValue__Alternatives2538); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getGenericValueAccess().getSTRINGTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1166:6: ( ruleINT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1166:6: ( ruleINT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1167:1: ruleINT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericValueAccess().getINTParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_rule__GenericValue__Alternatives2555);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1172:6: ( ruleFLOAT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1172:6: ( ruleFLOAT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1173:1: ruleFLOAT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericValueAccess().getFLOATParserRuleCall_2()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFLOAT_in_rule__GenericValue__Alternatives2572);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1183:1: rule__GenericNumber__Alternatives : ( ( ruleINT ) | ( ruleFLOAT ) );
    public final void rule__GenericNumber__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1187:1: ( ( ruleINT ) | ( ruleFLOAT ) )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1188:1: ( ruleINT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1188:1: ( ruleINT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1189:1: ruleINT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericNumberAccess().getINTParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleINT_in_rule__GenericNumber__Alternatives2604);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1194:6: ( ruleFLOAT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1194:6: ( ruleFLOAT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1195:1: ruleFLOAT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getGenericNumberAccess().getFLOATParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFLOAT_in_rule__GenericNumber__Alternatives2621);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1205:1: rule__INT__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__INT__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1209:1: ( ( '+' ) | ( '-' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==52) ) {
                alt11=1;
            }
            else if ( (LA11_0==53) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1210:1: ( '+' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1210:1: ( '+' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1211:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,52,FollowSets000.FOLLOW_52_in_rule__INT__Alternatives_02654); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1218:6: ( '-' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1218:6: ( '-' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1219:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,53,FollowSets000.FOLLOW_53_in_rule__INT__Alternatives_02674); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1231:1: rule__INT__Alternatives_1 : ( ( ( rule__INT__Group_1_0__0 ) ) | ( RULE_ZERO_INT ) | ( RULE_HEX ) );
    public final void rule__INT__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1235:1: ( ( ( rule__INT__Group_1_0__0 ) ) | ( RULE_ZERO_INT ) | ( RULE_HEX ) )
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1236:1: ( ( rule__INT__Group_1_0__0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1236:1: ( ( rule__INT__Group_1_0__0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1237:1: ( rule__INT__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getGroup_1_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1238:1: ( rule__INT__Group_1_0__0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1238:2: rule__INT__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__0_in_rule__INT__Alternatives_12708);
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1242:6: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1242:6: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1243:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_1()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__INT__Alternatives_12726); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1248:6: ( RULE_HEX )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1248:6: ( RULE_HEX )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1249:1: RULE_HEX
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getHEXTerminalRuleCall_1_2()); 
                    }
                    match(input,RULE_HEX,FollowSets000.FOLLOW_RULE_HEX_in_rule__INT__Alternatives_12743); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1259:1: rule__INT__Alternatives_1_0_1 : ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) );
    public final void rule__INT__Alternatives_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1263:1: ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) )
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1264:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1264:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1265:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_0_1_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__INT__Alternatives_1_0_12775); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getINTAccess().getZERO_INTTerminalRuleCall_1_0_1_0()); 
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
                       before(grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_1_1()); 
                    }
                    match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Alternatives_1_0_12792); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1281:1: rule__FLOAT__Alternatives_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__FLOAT__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1285:1: ( ( '+' ) | ( '-' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==52) ) {
                alt14=1;
            }
            else if ( (LA14_0==53) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1286:1: ( '+' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1286:1: ( '+' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1287:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFLOATAccess().getPlusSignKeyword_0_0()); 
                    }
                    match(input,52,FollowSets000.FOLLOW_52_in_rule__FLOAT__Alternatives_02825); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFLOATAccess().getPlusSignKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1294:6: ( '-' )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1294:6: ( '-' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1295:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFLOATAccess().getHyphenMinusKeyword_0_1()); 
                    }
                    match(input,53,FollowSets000.FOLLOW_53_in_rule__FLOAT__Alternatives_02845); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1307:1: rule__FLOAT__Alternatives_1 : ( ( RULE_ZERO_INT ) | ( ( rule__FLOAT__Group_1_1__0 ) ) );
    public final void rule__FLOAT__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1311:1: ( ( RULE_ZERO_INT ) | ( ( rule__FLOAT__Group_1_1__0 ) ) )
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1312:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1312:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1313:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFLOATAccess().getZERO_INTTerminalRuleCall_1_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__FLOAT__Alternatives_12879); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFLOATAccess().getZERO_INTTerminalRuleCall_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1318:6: ( ( rule__FLOAT__Group_1_1__0 ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1318:6: ( ( rule__FLOAT__Group_1_1__0 ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1319:1: ( rule__FLOAT__Group_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFLOATAccess().getGroup_1_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1320:1: ( rule__FLOAT__Group_1_1__0 )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1320:2: rule__FLOAT__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group_1_1__0_in_rule__FLOAT__Alternatives_12896);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1329:1: rule__FLOAT__Alternatives_1_1_1 : ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) );
    public final void rule__FLOAT__Alternatives_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1333:1: ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) )
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1334:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1334:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1335:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFLOATAccess().getZERO_INTTerminalRuleCall_1_1_1_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__FLOAT__Alternatives_1_1_12929); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFLOATAccess().getZERO_INTTerminalRuleCall_1_1_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1340:6: ( RULE_NON_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1340:6: ( RULE_NON_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1341:1: RULE_NON_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFLOATAccess().getNON_ZERO_INTTerminalRuleCall_1_1_1_1()); 
                    }
                    match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__FLOAT__Alternatives_1_1_12946); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1351:1: rule__FLOAT__Alternatives_3 : ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) );
    public final void rule__FLOAT__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1355:1: ( ( RULE_ZERO_INT ) | ( RULE_NON_ZERO_INT ) )
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1356:1: ( RULE_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1356:1: ( RULE_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1357:1: RULE_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFLOATAccess().getZERO_INTTerminalRuleCall_3_0()); 
                    }
                    match(input,RULE_ZERO_INT,FollowSets000.FOLLOW_RULE_ZERO_INT_in_rule__FLOAT__Alternatives_32978); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFLOATAccess().getZERO_INTTerminalRuleCall_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1362:6: ( RULE_NON_ZERO_INT )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1362:6: ( RULE_NON_ZERO_INT )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1363:1: RULE_NON_ZERO_INT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFLOATAccess().getNON_ZERO_INTTerminalRuleCall_3_1()); 
                    }
                    match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__FLOAT__Alternatives_32995); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1373:1: rule__VType__Alternatives : ( ( ( 'STRING' ) ) | ( ( 'UINT32' ) ) | ( ( 'INT32' ) ) | ( ( 'UINT64' ) ) | ( ( 'INT64' ) ) | ( ( 'FLOAT' ) ) );
    public final void rule__VType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1377:1: ( ( ( 'STRING' ) ) | ( ( 'UINT32' ) ) | ( ( 'INT32' ) ) | ( ( 'UINT64' ) ) | ( ( 'INT64' ) ) | ( ( 'FLOAT' ) ) )
            int alt18=6;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt18=1;
                }
                break;
            case 15:
                {
                alt18=2;
                }
                break;
            case 16:
                {
                alt18=3;
                }
                break;
            case 17:
                {
                alt18=4;
                }
                break;
            case 18:
                {
                alt18=5;
                }
                break;
            case 19:
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1378:1: ( ( 'STRING' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1378:1: ( ( 'STRING' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1379:1: ( 'STRING' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getSTRINGEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1380:1: ( 'STRING' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1380:3: 'STRING'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__VType__Alternatives3028); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getSTRINGEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1385:6: ( ( 'UINT32' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1385:6: ( ( 'UINT32' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1386:1: ( 'UINT32' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getUINT32EnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1387:1: ( 'UINT32' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1387:3: 'UINT32'
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__VType__Alternatives3049); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getUINT32EnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1392:6: ( ( 'INT32' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1392:6: ( ( 'INT32' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1393:1: ( 'INT32' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getINT32EnumLiteralDeclaration_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1394:1: ( 'INT32' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1394:3: 'INT32'
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__VType__Alternatives3070); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getINT32EnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1399:6: ( ( 'UINT64' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1399:6: ( ( 'UINT64' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1400:1: ( 'UINT64' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getUINT64EnumLiteralDeclaration_3()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1401:1: ( 'UINT64' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1401:3: 'UINT64'
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__VType__Alternatives3091); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getUINT64EnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1406:6: ( ( 'INT64' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1406:6: ( ( 'INT64' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1407:1: ( 'INT64' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getINT64EnumLiteralDeclaration_4()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1408:1: ( 'INT64' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1408:3: 'INT64'
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__VType__Alternatives3112); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVTypeAccess().getINT64EnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1413:6: ( ( 'FLOAT' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1413:6: ( ( 'FLOAT' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1414:1: ( 'FLOAT' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVTypeAccess().getFLOATEnumLiteralDeclaration_5()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1415:1: ( 'FLOAT' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1415:3: 'FLOAT'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__VType__Alternatives3133); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1425:1: rule__EType__Alternatives : ( ( ( 'BOOLEAN' ) ) | ( ( 'ENUM' ) ) );
    public final void rule__EType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1429:1: ( ( ( 'BOOLEAN' ) ) | ( ( 'ENUM' ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==20) ) {
                alt19=1;
            }
            else if ( (LA19_0==21) ) {
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1430:1: ( ( 'BOOLEAN' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1430:1: ( ( 'BOOLEAN' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1431:1: ( 'BOOLEAN' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getETypeAccess().getBOOLEANEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1432:1: ( 'BOOLEAN' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1432:3: 'BOOLEAN'
                    {
                    match(input,20,FollowSets000.FOLLOW_20_in_rule__EType__Alternatives3169); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getETypeAccess().getBOOLEANEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1437:6: ( ( 'ENUM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1437:6: ( ( 'ENUM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1438:1: ( 'ENUM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getETypeAccess().getENUMEnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1439:1: ( 'ENUM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1439:3: 'ENUM'
                    {
                    match(input,21,FollowSets000.FOLLOW_21_in_rule__EType__Alternatives3190); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1449:1: rule__ObjectType__Alternatives : ( ( ( 'OS' ) ) | ( ( 'ALARM' ) ) | ( ( 'APPMODE' ) ) | ( ( 'COUNTER' ) ) | ( ( 'COM' ) ) | ( ( 'EVENT' ) ) | ( ( 'IPDU' ) ) | ( ( 'ISR' ) ) | ( ( 'MESSAGE' ) ) | ( ( 'NETWORKMESSAGE' ) ) | ( ( 'NM' ) ) | ( ( 'RESOURCE' ) ) | ( ( 'TASK' ) ) | ( ( 'APPLICATION' ) ) | ( ( 'SPINLOCK' ) ) | ( ( 'SCHEDULETABLE' ) ) );
    public final void rule__ObjectType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1453:1: ( ( ( 'OS' ) ) | ( ( 'ALARM' ) ) | ( ( 'APPMODE' ) ) | ( ( 'COUNTER' ) ) | ( ( 'COM' ) ) | ( ( 'EVENT' ) ) | ( ( 'IPDU' ) ) | ( ( 'ISR' ) ) | ( ( 'MESSAGE' ) ) | ( ( 'NETWORKMESSAGE' ) ) | ( ( 'NM' ) ) | ( ( 'RESOURCE' ) ) | ( ( 'TASK' ) ) | ( ( 'APPLICATION' ) ) | ( ( 'SPINLOCK' ) ) | ( ( 'SCHEDULETABLE' ) ) )
            int alt20=16;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt20=1;
                }
                break;
            case 23:
                {
                alt20=2;
                }
                break;
            case 24:
                {
                alt20=3;
                }
                break;
            case 25:
                {
                alt20=4;
                }
                break;
            case 26:
                {
                alt20=5;
                }
                break;
            case 27:
                {
                alt20=6;
                }
                break;
            case 28:
                {
                alt20=7;
                }
                break;
            case 29:
                {
                alt20=8;
                }
                break;
            case 30:
                {
                alt20=9;
                }
                break;
            case 31:
                {
                alt20=10;
                }
                break;
            case 32:
                {
                alt20=11;
                }
                break;
            case 33:
                {
                alt20=12;
                }
                break;
            case 34:
                {
                alt20=13;
                }
                break;
            case 54:
                {
                alt20=14;
                }
                break;
            case 35:
                {
                alt20=15;
                }
                break;
            case 36:
                {
                alt20=16;
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1454:1: ( ( 'OS' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1454:1: ( ( 'OS' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1455:1: ( 'OS' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getOSEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1456:1: ( 'OS' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1456:3: 'OS'
                    {
                    match(input,22,FollowSets000.FOLLOW_22_in_rule__ObjectType__Alternatives3226); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getOSEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1461:6: ( ( 'ALARM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1461:6: ( ( 'ALARM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1462:1: ( 'ALARM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getALARMEnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1463:1: ( 'ALARM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1463:3: 'ALARM'
                    {
                    match(input,23,FollowSets000.FOLLOW_23_in_rule__ObjectType__Alternatives3247); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getALARMEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1468:6: ( ( 'APPMODE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1468:6: ( ( 'APPMODE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1469:1: ( 'APPMODE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1470:1: ( 'APPMODE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1470:3: 'APPMODE'
                    {
                    match(input,24,FollowSets000.FOLLOW_24_in_rule__ObjectType__Alternatives3268); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1475:6: ( ( 'COUNTER' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1475:6: ( ( 'COUNTER' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1476:1: ( 'COUNTER' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1477:1: ( 'COUNTER' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1477:3: 'COUNTER'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_rule__ObjectType__Alternatives3289); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1482:6: ( ( 'COM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1482:6: ( ( 'COM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1483:1: ( 'COM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getCOMEnumLiteralDeclaration_4()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1484:1: ( 'COM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1484:3: 'COM'
                    {
                    match(input,26,FollowSets000.FOLLOW_26_in_rule__ObjectType__Alternatives3310); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getCOMEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1489:6: ( ( 'EVENT' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1489:6: ( ( 'EVENT' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1490:1: ( 'EVENT' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1491:1: ( 'EVENT' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1491:3: 'EVENT'
                    {
                    match(input,27,FollowSets000.FOLLOW_27_in_rule__ObjectType__Alternatives3331); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1496:6: ( ( 'IPDU' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1496:6: ( ( 'IPDU' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1497:1: ( 'IPDU' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1498:1: ( 'IPDU' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1498:3: 'IPDU'
                    {
                    match(input,28,FollowSets000.FOLLOW_28_in_rule__ObjectType__Alternatives3352); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1503:6: ( ( 'ISR' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1503:6: ( ( 'ISR' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1504:1: ( 'ISR' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getISREnumLiteralDeclaration_7()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1505:1: ( 'ISR' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1505:3: 'ISR'
                    {
                    match(input,29,FollowSets000.FOLLOW_29_in_rule__ObjectType__Alternatives3373); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getISREnumLiteralDeclaration_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1510:6: ( ( 'MESSAGE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1510:6: ( ( 'MESSAGE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1511:1: ( 'MESSAGE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1512:1: ( 'MESSAGE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1512:3: 'MESSAGE'
                    {
                    match(input,30,FollowSets000.FOLLOW_30_in_rule__ObjectType__Alternatives3394); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1517:6: ( ( 'NETWORKMESSAGE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1517:6: ( ( 'NETWORKMESSAGE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1518:1: ( 'NETWORKMESSAGE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1519:1: ( 'NETWORKMESSAGE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1519:3: 'NETWORKMESSAGE'
                    {
                    match(input,31,FollowSets000.FOLLOW_31_in_rule__ObjectType__Alternatives3415); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1524:6: ( ( 'NM' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1524:6: ( ( 'NM' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1525:1: ( 'NM' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getNMEnumLiteralDeclaration_10()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1526:1: ( 'NM' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1526:3: 'NM'
                    {
                    match(input,32,FollowSets000.FOLLOW_32_in_rule__ObjectType__Alternatives3436); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getNMEnumLiteralDeclaration_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1531:6: ( ( 'RESOURCE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1531:6: ( ( 'RESOURCE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1532:1: ( 'RESOURCE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1533:1: ( 'RESOURCE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1533:3: 'RESOURCE'
                    {
                    match(input,33,FollowSets000.FOLLOW_33_in_rule__ObjectType__Alternatives3457); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1538:6: ( ( 'TASK' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1538:6: ( ( 'TASK' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1539:1: ( 'TASK' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getTASKEnumLiteralDeclaration_12()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1540:1: ( 'TASK' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1540:3: 'TASK'
                    {
                    match(input,34,FollowSets000.FOLLOW_34_in_rule__ObjectType__Alternatives3478); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getTASKEnumLiteralDeclaration_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1545:6: ( ( 'APPLICATION' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1545:6: ( ( 'APPLICATION' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1546:1: ( 'APPLICATION' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getAPPLICATIONEnumLiteralDeclaration_13()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1547:1: ( 'APPLICATION' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1547:3: 'APPLICATION'
                    {
                    match(input,54,FollowSets000.FOLLOW_54_in_rule__ObjectType__Alternatives3499); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getAPPLICATIONEnumLiteralDeclaration_13()); 
                    }

                    }


                    }
                    break;
                case 15 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1552:6: ( ( 'SPINLOCK' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1552:6: ( ( 'SPINLOCK' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1553:1: ( 'SPINLOCK' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getSPINLOCKEnumLiteralDeclaration_14()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1554:1: ( 'SPINLOCK' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1554:3: 'SPINLOCK'
                    {
                    match(input,35,FollowSets000.FOLLOW_35_in_rule__ObjectType__Alternatives3520); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getSPINLOCKEnumLiteralDeclaration_14()); 
                    }

                    }


                    }
                    break;
                case 16 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1559:6: ( ( 'SCHEDULETABLE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1559:6: ( ( 'SCHEDULETABLE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1560:1: ( 'SCHEDULETABLE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeAccess().getSCHEDULETABLEEnumLiteralDeclaration_15()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1561:1: ( 'SCHEDULETABLE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1561:3: 'SCHEDULETABLE'
                    {
                    match(input,36,FollowSets000.FOLLOW_36_in_rule__ObjectType__Alternatives3541); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeAccess().getSCHEDULETABLEEnumLiteralDeclaration_15()); 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1571:1: rule__ObjectTypeRef__Alternatives : ( ( ( 'OS_TYPE' ) ) | ( ( 'ALARM_TYPE' ) ) | ( ( 'APPMODE_TYPE' ) ) | ( ( 'COUNTER_TYPE' ) ) | ( ( 'COM_TYPE' ) ) | ( ( 'EVENT_TYPE' ) ) | ( ( 'IPDU_TYPE' ) ) | ( ( 'ISR_TYPE' ) ) | ( ( 'MESSAGE_TYPE' ) ) | ( ( 'NETWORKMESSAGE_TYPE' ) ) | ( ( 'NM_TYPE' ) ) | ( ( 'RESOURCE_TYPE' ) ) | ( ( 'TASK_TYPE' ) ) | ( ( 'APPLICATION_TYPE' ) ) | ( ( 'SPINLOCK_TYPE' ) ) | ( ( 'SCHEDULETABLE_TYPE' ) ) );
    public final void rule__ObjectTypeRef__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1575:1: ( ( ( 'OS_TYPE' ) ) | ( ( 'ALARM_TYPE' ) ) | ( ( 'APPMODE_TYPE' ) ) | ( ( 'COUNTER_TYPE' ) ) | ( ( 'COM_TYPE' ) ) | ( ( 'EVENT_TYPE' ) ) | ( ( 'IPDU_TYPE' ) ) | ( ( 'ISR_TYPE' ) ) | ( ( 'MESSAGE_TYPE' ) ) | ( ( 'NETWORKMESSAGE_TYPE' ) ) | ( ( 'NM_TYPE' ) ) | ( ( 'RESOURCE_TYPE' ) ) | ( ( 'TASK_TYPE' ) ) | ( ( 'APPLICATION_TYPE' ) ) | ( ( 'SPINLOCK_TYPE' ) ) | ( ( 'SCHEDULETABLE_TYPE' ) ) )
            int alt21=16;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt21=1;
                }
                break;
            case 38:
                {
                alt21=2;
                }
                break;
            case 39:
                {
                alt21=3;
                }
                break;
            case 40:
                {
                alt21=4;
                }
                break;
            case 41:
                {
                alt21=5;
                }
                break;
            case 42:
                {
                alt21=6;
                }
                break;
            case 43:
                {
                alt21=7;
                }
                break;
            case 44:
                {
                alt21=8;
                }
                break;
            case 45:
                {
                alt21=9;
                }
                break;
            case 46:
                {
                alt21=10;
                }
                break;
            case 47:
                {
                alt21=11;
                }
                break;
            case 48:
                {
                alt21=12;
                }
                break;
            case 49:
                {
                alt21=13;
                }
                break;
            case 55:
                {
                alt21=14;
                }
                break;
            case 50:
                {
                alt21=15;
                }
                break;
            case 51:
                {
                alt21=16;
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
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1576:1: ( ( 'OS_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1576:1: ( ( 'OS_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1577:1: ( 'OS_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getOSEnumLiteralDeclaration_0()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1578:1: ( 'OS_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1578:3: 'OS_TYPE'
                    {
                    match(input,37,FollowSets000.FOLLOW_37_in_rule__ObjectTypeRef__Alternatives3577); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getOSEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1583:6: ( ( 'ALARM_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1583:6: ( ( 'ALARM_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1584:1: ( 'ALARM_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getALARMEnumLiteralDeclaration_1()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1585:1: ( 'ALARM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1585:3: 'ALARM_TYPE'
                    {
                    match(input,38,FollowSets000.FOLLOW_38_in_rule__ObjectTypeRef__Alternatives3598); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getALARMEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1590:6: ( ( 'APPMODE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1590:6: ( ( 'APPMODE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1591:1: ( 'APPMODE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1592:1: ( 'APPMODE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1592:3: 'APPMODE_TYPE'
                    {
                    match(input,39,FollowSets000.FOLLOW_39_in_rule__ObjectTypeRef__Alternatives3619); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getAPPMODEEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1597:6: ( ( 'COUNTER_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1597:6: ( ( 'COUNTER_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1598:1: ( 'COUNTER_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1599:1: ( 'COUNTER_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1599:3: 'COUNTER_TYPE'
                    {
                    match(input,40,FollowSets000.FOLLOW_40_in_rule__ObjectTypeRef__Alternatives3640); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getCOUNTEREnumLiteralDeclaration_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1604:6: ( ( 'COM_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1604:6: ( ( 'COM_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1605:1: ( 'COM_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getCOMEnumLiteralDeclaration_4()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1606:1: ( 'COM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1606:3: 'COM_TYPE'
                    {
                    match(input,41,FollowSets000.FOLLOW_41_in_rule__ObjectTypeRef__Alternatives3661); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getCOMEnumLiteralDeclaration_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1611:6: ( ( 'EVENT_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1611:6: ( ( 'EVENT_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1612:1: ( 'EVENT_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1613:1: ( 'EVENT_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1613:3: 'EVENT_TYPE'
                    {
                    match(input,42,FollowSets000.FOLLOW_42_in_rule__ObjectTypeRef__Alternatives3682); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getEVENTEnumLiteralDeclaration_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1618:6: ( ( 'IPDU_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1618:6: ( ( 'IPDU_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1619:1: ( 'IPDU_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1620:1: ( 'IPDU_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1620:3: 'IPDU_TYPE'
                    {
                    match(input,43,FollowSets000.FOLLOW_43_in_rule__ObjectTypeRef__Alternatives3703); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getIPDUEnumLiteralDeclaration_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1625:6: ( ( 'ISR_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1625:6: ( ( 'ISR_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1626:1: ( 'ISR_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getISREnumLiteralDeclaration_7()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1627:1: ( 'ISR_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1627:3: 'ISR_TYPE'
                    {
                    match(input,44,FollowSets000.FOLLOW_44_in_rule__ObjectTypeRef__Alternatives3724); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getISREnumLiteralDeclaration_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1632:6: ( ( 'MESSAGE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1632:6: ( ( 'MESSAGE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1633:1: ( 'MESSAGE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1634:1: ( 'MESSAGE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1634:3: 'MESSAGE_TYPE'
                    {
                    match(input,45,FollowSets000.FOLLOW_45_in_rule__ObjectTypeRef__Alternatives3745); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getMESSAGEEnumLiteralDeclaration_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1639:6: ( ( 'NETWORKMESSAGE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1639:6: ( ( 'NETWORKMESSAGE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1640:1: ( 'NETWORKMESSAGE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1641:1: ( 'NETWORKMESSAGE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1641:3: 'NETWORKMESSAGE_TYPE'
                    {
                    match(input,46,FollowSets000.FOLLOW_46_in_rule__ObjectTypeRef__Alternatives3766); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getNETWORKMESSAGEEnumLiteralDeclaration_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1646:6: ( ( 'NM_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1646:6: ( ( 'NM_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1647:1: ( 'NM_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getNMEnumLiteralDeclaration_10()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1648:1: ( 'NM_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1648:3: 'NM_TYPE'
                    {
                    match(input,47,FollowSets000.FOLLOW_47_in_rule__ObjectTypeRef__Alternatives3787); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getNMEnumLiteralDeclaration_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1653:6: ( ( 'RESOURCE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1653:6: ( ( 'RESOURCE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1654:1: ( 'RESOURCE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1655:1: ( 'RESOURCE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1655:3: 'RESOURCE_TYPE'
                    {
                    match(input,48,FollowSets000.FOLLOW_48_in_rule__ObjectTypeRef__Alternatives3808); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getRESOURCEEnumLiteralDeclaration_11()); 
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1660:6: ( ( 'TASK_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1660:6: ( ( 'TASK_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1661:1: ( 'TASK_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getTASKEnumLiteralDeclaration_12()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1662:1: ( 'TASK_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1662:3: 'TASK_TYPE'
                    {
                    match(input,49,FollowSets000.FOLLOW_49_in_rule__ObjectTypeRef__Alternatives3829); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getTASKEnumLiteralDeclaration_12()); 
                    }

                    }


                    }
                    break;
                case 14 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1667:6: ( ( 'APPLICATION_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1667:6: ( ( 'APPLICATION_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1668:1: ( 'APPLICATION_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getAPPLICATIONEnumLiteralDeclaration_13()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1669:1: ( 'APPLICATION_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1669:3: 'APPLICATION_TYPE'
                    {
                    match(input,55,FollowSets000.FOLLOW_55_in_rule__ObjectTypeRef__Alternatives3850); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getAPPLICATIONEnumLiteralDeclaration_13()); 
                    }

                    }


                    }
                    break;
                case 15 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1674:6: ( ( 'SPINLOCK_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1674:6: ( ( 'SPINLOCK_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1675:1: ( 'SPINLOCK_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getSPINLOCKEnumLiteralDeclaration_14()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1676:1: ( 'SPINLOCK_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1676:3: 'SPINLOCK_TYPE'
                    {
                    match(input,50,FollowSets000.FOLLOW_50_in_rule__ObjectTypeRef__Alternatives3871); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getSPINLOCKEnumLiteralDeclaration_14()); 
                    }

                    }


                    }
                    break;
                case 16 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1681:6: ( ( 'SCHEDULETABLE_TYPE' ) )
                    {
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1681:6: ( ( 'SCHEDULETABLE_TYPE' ) )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1682:1: ( 'SCHEDULETABLE_TYPE' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectTypeRefAccess().getSCHEDULETABLEEnumLiteralDeclaration_15()); 
                    }
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1683:1: ( 'SCHEDULETABLE_TYPE' )
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1683:3: 'SCHEDULETABLE_TYPE'
                    {
                    match(input,51,FollowSets000.FOLLOW_51_in_rule__ObjectTypeRef__Alternatives3892); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectTypeRefAccess().getSCHEDULETABLEEnumLiteralDeclaration_15()); 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1695:1: rule__OilFile__Group__0 : rule__OilFile__Group__0__Impl rule__OilFile__Group__1 ;
    public final void rule__OilFile__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1699:1: ( rule__OilFile__Group__0__Impl rule__OilFile__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1700:2: rule__OilFile__Group__0__Impl rule__OilFile__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__0__Impl_in_rule__OilFile__Group__03925);
            rule__OilFile__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__1_in_rule__OilFile__Group__03928);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1707:1: rule__OilFile__Group__0__Impl : ( () ) ;
    public final void rule__OilFile__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1711:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1712:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1712:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1713:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getOilFileAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1714:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1716:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1726:1: rule__OilFile__Group__1 : rule__OilFile__Group__1__Impl rule__OilFile__Group__2 ;
    public final void rule__OilFile__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1730:1: ( rule__OilFile__Group__1__Impl rule__OilFile__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1731:2: rule__OilFile__Group__1__Impl rule__OilFile__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__1__Impl_in_rule__OilFile__Group__13986);
            rule__OilFile__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__2_in_rule__OilFile__Group__13989);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1738:1: rule__OilFile__Group__1__Impl : ( ( rule__OilFile__Group_1__0 )? ) ;
    public final void rule__OilFile__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1742:1: ( ( ( rule__OilFile__Group_1__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1743:1: ( ( rule__OilFile__Group_1__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1743:1: ( ( rule__OilFile__Group_1__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1744:1: ( rule__OilFile__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getGroup_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1745:1: ( rule__OilFile__Group_1__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==56) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1745:2: rule__OilFile__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__0_in_rule__OilFile__Group__1__Impl4016);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1755:1: rule__OilFile__Group__2 : rule__OilFile__Group__2__Impl rule__OilFile__Group__3 ;
    public final void rule__OilFile__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1759:1: ( rule__OilFile__Group__2__Impl rule__OilFile__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1760:2: rule__OilFile__Group__2__Impl rule__OilFile__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__2__Impl_in_rule__OilFile__Group__24047);
            rule__OilFile__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__3_in_rule__OilFile__Group__24050);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1767:1: rule__OilFile__Group__2__Impl : ( ( rule__OilFile__ImplementationAssignment_2 )? ) ;
    public final void rule__OilFile__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1771:1: ( ( ( rule__OilFile__ImplementationAssignment_2 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1772:1: ( ( rule__OilFile__ImplementationAssignment_2 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1772:1: ( ( rule__OilFile__ImplementationAssignment_2 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1773:1: ( rule__OilFile__ImplementationAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getImplementationAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1774:1: ( rule__OilFile__ImplementationAssignment_2 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==59) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1774:2: rule__OilFile__ImplementationAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilFile__ImplementationAssignment_2_in_rule__OilFile__Group__2__Impl4077);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1784:1: rule__OilFile__Group__3 : rule__OilFile__Group__3__Impl ;
    public final void rule__OilFile__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1788:1: ( rule__OilFile__Group__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1789:2: rule__OilFile__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group__3__Impl_in_rule__OilFile__Group__34108);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1795:1: rule__OilFile__Group__3__Impl : ( ( rule__OilFile__ApplicationAssignment_3 )? ) ;
    public final void rule__OilFile__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1799:1: ( ( ( rule__OilFile__ApplicationAssignment_3 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1800:1: ( ( rule__OilFile__ApplicationAssignment_3 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1800:1: ( ( rule__OilFile__ApplicationAssignment_3 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1801:1: ( rule__OilFile__ApplicationAssignment_3 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getApplicationAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1802:1: ( rule__OilFile__ApplicationAssignment_3 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==63) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1802:2: rule__OilFile__ApplicationAssignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilFile__ApplicationAssignment_3_in_rule__OilFile__Group__3__Impl4135);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1820:1: rule__OilFile__Group_1__0 : rule__OilFile__Group_1__0__Impl rule__OilFile__Group_1__1 ;
    public final void rule__OilFile__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1824:1: ( rule__OilFile__Group_1__0__Impl rule__OilFile__Group_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1825:2: rule__OilFile__Group_1__0__Impl rule__OilFile__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__0__Impl_in_rule__OilFile__Group_1__04174);
            rule__OilFile__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__1_in_rule__OilFile__Group_1__04177);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1832:1: rule__OilFile__Group_1__0__Impl : ( 'OIL_VERSION' ) ;
    public final void rule__OilFile__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1836:1: ( ( 'OIL_VERSION' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1837:1: ( 'OIL_VERSION' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1837:1: ( 'OIL_VERSION' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1838:1: 'OIL_VERSION'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getOIL_VERSIONKeyword_1_0()); 
            }
            match(input,56,FollowSets000.FOLLOW_56_in_rule__OilFile__Group_1__0__Impl4205); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1851:1: rule__OilFile__Group_1__1 : rule__OilFile__Group_1__1__Impl rule__OilFile__Group_1__2 ;
    public final void rule__OilFile__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1855:1: ( rule__OilFile__Group_1__1__Impl rule__OilFile__Group_1__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1856:2: rule__OilFile__Group_1__1__Impl rule__OilFile__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__1__Impl_in_rule__OilFile__Group_1__14236);
            rule__OilFile__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__2_in_rule__OilFile__Group_1__14239);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1863:1: rule__OilFile__Group_1__1__Impl : ( '=' ) ;
    public final void rule__OilFile__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1867:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1868:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1868:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1869:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getEqualsSignKeyword_1_1()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__OilFile__Group_1__1__Impl4267); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1882:1: rule__OilFile__Group_1__2 : rule__OilFile__Group_1__2__Impl rule__OilFile__Group_1__3 ;
    public final void rule__OilFile__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1886:1: ( rule__OilFile__Group_1__2__Impl rule__OilFile__Group_1__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1887:2: rule__OilFile__Group_1__2__Impl rule__OilFile__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__2__Impl_in_rule__OilFile__Group_1__24298);
            rule__OilFile__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__3_in_rule__OilFile__Group_1__24301);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1894:1: rule__OilFile__Group_1__2__Impl : ( ( rule__OilFile__OilVersionAssignment_1_2 ) ) ;
    public final void rule__OilFile__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1898:1: ( ( ( rule__OilFile__OilVersionAssignment_1_2 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1899:1: ( ( rule__OilFile__OilVersionAssignment_1_2 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1899:1: ( ( rule__OilFile__OilVersionAssignment_1_2 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1900:1: ( rule__OilFile__OilVersionAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getOilVersionAssignment_1_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1901:1: ( rule__OilFile__OilVersionAssignment_1_2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1901:2: rule__OilFile__OilVersionAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__OilVersionAssignment_1_2_in_rule__OilFile__Group_1__2__Impl4328);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1911:1: rule__OilFile__Group_1__3 : rule__OilFile__Group_1__3__Impl ;
    public final void rule__OilFile__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1915:1: ( rule__OilFile__Group_1__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1916:2: rule__OilFile__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilFile__Group_1__3__Impl_in_rule__OilFile__Group_1__34358);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1922:1: rule__OilFile__Group_1__3__Impl : ( ';' ) ;
    public final void rule__OilFile__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1926:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1927:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1927:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1928:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getSemicolonKeyword_1_3()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__OilFile__Group_1__3__Impl4386); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1949:1: rule__OilImplementation__Group__0 : rule__OilImplementation__Group__0__Impl rule__OilImplementation__Group__1 ;
    public final void rule__OilImplementation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1953:1: ( rule__OilImplementation__Group__0__Impl rule__OilImplementation__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1954:2: rule__OilImplementation__Group__0__Impl rule__OilImplementation__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__0__Impl_in_rule__OilImplementation__Group__04425);
            rule__OilImplementation__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__1_in_rule__OilImplementation__Group__04428);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1961:1: rule__OilImplementation__Group__0__Impl : ( 'IMPLEMENTATION' ) ;
    public final void rule__OilImplementation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1965:1: ( ( 'IMPLEMENTATION' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1966:1: ( 'IMPLEMENTATION' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1966:1: ( 'IMPLEMENTATION' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1967:1: 'IMPLEMENTATION'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getIMPLEMENTATIONKeyword_0()); 
            }
            match(input,59,FollowSets000.FOLLOW_59_in_rule__OilImplementation__Group__0__Impl4456); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1980:1: rule__OilImplementation__Group__1 : rule__OilImplementation__Group__1__Impl rule__OilImplementation__Group__2 ;
    public final void rule__OilImplementation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1984:1: ( rule__OilImplementation__Group__1__Impl rule__OilImplementation__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1985:2: rule__OilImplementation__Group__1__Impl rule__OilImplementation__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__1__Impl_in_rule__OilImplementation__Group__14487);
            rule__OilImplementation__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__2_in_rule__OilImplementation__Group__14490);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1992:1: rule__OilImplementation__Group__1__Impl : ( ( rule__OilImplementation__NameAssignment_1 ) ) ;
    public final void rule__OilImplementation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1996:1: ( ( ( rule__OilImplementation__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1997:1: ( ( rule__OilImplementation__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1997:1: ( ( rule__OilImplementation__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1998:1: ( rule__OilImplementation__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1999:1: ( rule__OilImplementation__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:1999:2: rule__OilImplementation__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__NameAssignment_1_in_rule__OilImplementation__Group__1__Impl4517);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2009:1: rule__OilImplementation__Group__2 : rule__OilImplementation__Group__2__Impl rule__OilImplementation__Group__3 ;
    public final void rule__OilImplementation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2013:1: ( rule__OilImplementation__Group__2__Impl rule__OilImplementation__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2014:2: rule__OilImplementation__Group__2__Impl rule__OilImplementation__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__2__Impl_in_rule__OilImplementation__Group__24547);
            rule__OilImplementation__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__3_in_rule__OilImplementation__Group__24550);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2021:1: rule__OilImplementation__Group__2__Impl : ( '{' ) ;
    public final void rule__OilImplementation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2025:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2026:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2026:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2027:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,60,FollowSets000.FOLLOW_60_in_rule__OilImplementation__Group__2__Impl4578); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2040:1: rule__OilImplementation__Group__3 : rule__OilImplementation__Group__3__Impl rule__OilImplementation__Group__4 ;
    public final void rule__OilImplementation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2044:1: ( rule__OilImplementation__Group__3__Impl rule__OilImplementation__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2045:2: rule__OilImplementation__Group__3__Impl rule__OilImplementation__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__3__Impl_in_rule__OilImplementation__Group__34609);
            rule__OilImplementation__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__4_in_rule__OilImplementation__Group__34612);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2052:1: rule__OilImplementation__Group__3__Impl : ( ( rule__OilImplementation__OilObjectsAssignment_3 )* ) ;
    public final void rule__OilImplementation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2056:1: ( ( ( rule__OilImplementation__OilObjectsAssignment_3 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2057:1: ( ( rule__OilImplementation__OilObjectsAssignment_3 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2057:1: ( ( rule__OilImplementation__OilObjectsAssignment_3 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2058:1: ( rule__OilImplementation__OilObjectsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getOilObjectsAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2059:1: ( rule__OilImplementation__OilObjectsAssignment_3 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=22 && LA25_0<=36)||LA25_0==54) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2059:2: rule__OilImplementation__OilObjectsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__OilObjectsAssignment_3_in_rule__OilImplementation__Group__3__Impl4639);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2069:1: rule__OilImplementation__Group__4 : rule__OilImplementation__Group__4__Impl rule__OilImplementation__Group__5 ;
    public final void rule__OilImplementation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2073:1: ( rule__OilImplementation__Group__4__Impl rule__OilImplementation__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2074:2: rule__OilImplementation__Group__4__Impl rule__OilImplementation__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__4__Impl_in_rule__OilImplementation__Group__44670);
            rule__OilImplementation__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__5_in_rule__OilImplementation__Group__44673);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2081:1: rule__OilImplementation__Group__4__Impl : ( '}' ) ;
    public final void rule__OilImplementation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2085:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2086:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2086:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2087:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,61,FollowSets000.FOLLOW_61_in_rule__OilImplementation__Group__4__Impl4701); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2100:1: rule__OilImplementation__Group__5 : rule__OilImplementation__Group__5__Impl ;
    public final void rule__OilImplementation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2104:1: ( rule__OilImplementation__Group__5__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2105:2: rule__OilImplementation__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilImplementation__Group__5__Impl_in_rule__OilImplementation__Group__54732);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2111:1: rule__OilImplementation__Group__5__Impl : ( ';' ) ;
    public final void rule__OilImplementation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2115:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2116:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2116:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2117:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getSemicolonKeyword_5()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__OilImplementation__Group__5__Impl4760); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2142:1: rule__OilObjectImpl__Group__0 : rule__OilObjectImpl__Group__0__Impl rule__OilObjectImpl__Group__1 ;
    public final void rule__OilObjectImpl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2146:1: ( rule__OilObjectImpl__Group__0__Impl rule__OilObjectImpl__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2147:2: rule__OilObjectImpl__Group__0__Impl rule__OilObjectImpl__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__0__Impl_in_rule__OilObjectImpl__Group__04803);
            rule__OilObjectImpl__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__1_in_rule__OilObjectImpl__Group__04806);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2154:1: rule__OilObjectImpl__Group__0__Impl : ( ( rule__OilObjectImpl__TypeAssignment_0 ) ) ;
    public final void rule__OilObjectImpl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2158:1: ( ( ( rule__OilObjectImpl__TypeAssignment_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2159:1: ( ( rule__OilObjectImpl__TypeAssignment_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2159:1: ( ( rule__OilObjectImpl__TypeAssignment_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2160:1: ( rule__OilObjectImpl__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getTypeAssignment_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2161:1: ( rule__OilObjectImpl__TypeAssignment_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2161:2: rule__OilObjectImpl__TypeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__TypeAssignment_0_in_rule__OilObjectImpl__Group__0__Impl4833);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2171:1: rule__OilObjectImpl__Group__1 : rule__OilObjectImpl__Group__1__Impl rule__OilObjectImpl__Group__2 ;
    public final void rule__OilObjectImpl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2175:1: ( rule__OilObjectImpl__Group__1__Impl rule__OilObjectImpl__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2176:2: rule__OilObjectImpl__Group__1__Impl rule__OilObjectImpl__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__1__Impl_in_rule__OilObjectImpl__Group__14863);
            rule__OilObjectImpl__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__2_in_rule__OilObjectImpl__Group__14866);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2183:1: rule__OilObjectImpl__Group__1__Impl : ( '{' ) ;
    public final void rule__OilObjectImpl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2187:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2188:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2188:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2189:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,60,FollowSets000.FOLLOW_60_in_rule__OilObjectImpl__Group__1__Impl4894); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2202:1: rule__OilObjectImpl__Group__2 : rule__OilObjectImpl__Group__2__Impl rule__OilObjectImpl__Group__3 ;
    public final void rule__OilObjectImpl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2206:1: ( rule__OilObjectImpl__Group__2__Impl rule__OilObjectImpl__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2207:2: rule__OilObjectImpl__Group__2__Impl rule__OilObjectImpl__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__2__Impl_in_rule__OilObjectImpl__Group__24925);
            rule__OilObjectImpl__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__3_in_rule__OilObjectImpl__Group__24928);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2214:1: rule__OilObjectImpl__Group__2__Impl : ( ( rule__OilObjectImpl__ParametersAssignment_2 )* ) ;
    public final void rule__OilObjectImpl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2218:1: ( ( ( rule__OilObjectImpl__ParametersAssignment_2 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2219:1: ( ( rule__OilObjectImpl__ParametersAssignment_2 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2219:1: ( ( rule__OilObjectImpl__ParametersAssignment_2 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2220:1: ( rule__OilObjectImpl__ParametersAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getParametersAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2221:1: ( rule__OilObjectImpl__ParametersAssignment_2 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=14 && LA26_0<=21)||(LA26_0>=37 && LA26_0<=51)||LA26_0==55) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2221:2: rule__OilObjectImpl__ParametersAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__ParametersAssignment_2_in_rule__OilObjectImpl__Group__2__Impl4955);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2231:1: rule__OilObjectImpl__Group__3 : rule__OilObjectImpl__Group__3__Impl rule__OilObjectImpl__Group__4 ;
    public final void rule__OilObjectImpl__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2235:1: ( rule__OilObjectImpl__Group__3__Impl rule__OilObjectImpl__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2236:2: rule__OilObjectImpl__Group__3__Impl rule__OilObjectImpl__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__3__Impl_in_rule__OilObjectImpl__Group__34986);
            rule__OilObjectImpl__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__4_in_rule__OilObjectImpl__Group__34989);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2243:1: rule__OilObjectImpl__Group__3__Impl : ( '}' ) ;
    public final void rule__OilObjectImpl__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2247:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2248:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2248:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2249:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,61,FollowSets000.FOLLOW_61_in_rule__OilObjectImpl__Group__3__Impl5017); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2262:1: rule__OilObjectImpl__Group__4 : rule__OilObjectImpl__Group__4__Impl rule__OilObjectImpl__Group__5 ;
    public final void rule__OilObjectImpl__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2266:1: ( rule__OilObjectImpl__Group__4__Impl rule__OilObjectImpl__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2267:2: rule__OilObjectImpl__Group__4__Impl rule__OilObjectImpl__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__4__Impl_in_rule__OilObjectImpl__Group__45048);
            rule__OilObjectImpl__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__5_in_rule__OilObjectImpl__Group__45051);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2274:1: rule__OilObjectImpl__Group__4__Impl : ( ( rule__OilObjectImpl__Group_4__0 )? ) ;
    public final void rule__OilObjectImpl__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2278:1: ( ( ( rule__OilObjectImpl__Group_4__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2279:1: ( ( rule__OilObjectImpl__Group_4__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2279:1: ( ( rule__OilObjectImpl__Group_4__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2280:1: ( rule__OilObjectImpl__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getGroup_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2281:1: ( rule__OilObjectImpl__Group_4__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==62) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2281:2: rule__OilObjectImpl__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__0_in_rule__OilObjectImpl__Group__4__Impl5078);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2291:1: rule__OilObjectImpl__Group__5 : rule__OilObjectImpl__Group__5__Impl ;
    public final void rule__OilObjectImpl__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2295:1: ( rule__OilObjectImpl__Group__5__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2296:2: rule__OilObjectImpl__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group__5__Impl_in_rule__OilObjectImpl__Group__55109);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2302:1: rule__OilObjectImpl__Group__5__Impl : ( ';' ) ;
    public final void rule__OilObjectImpl__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2306:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2307:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2307:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2308:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getSemicolonKeyword_5()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__OilObjectImpl__Group__5__Impl5137); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2333:1: rule__OilObjectImpl__Group_4__0 : rule__OilObjectImpl__Group_4__0__Impl rule__OilObjectImpl__Group_4__1 ;
    public final void rule__OilObjectImpl__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2337:1: ( rule__OilObjectImpl__Group_4__0__Impl rule__OilObjectImpl__Group_4__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2338:2: rule__OilObjectImpl__Group_4__0__Impl rule__OilObjectImpl__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__0__Impl_in_rule__OilObjectImpl__Group_4__05180);
            rule__OilObjectImpl__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__1_in_rule__OilObjectImpl__Group_4__05183);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2345:1: rule__OilObjectImpl__Group_4__0__Impl : ( ':' ) ;
    public final void rule__OilObjectImpl__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2349:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2350:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2350:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2351:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getColonKeyword_4_0()); 
            }
            match(input,62,FollowSets000.FOLLOW_62_in_rule__OilObjectImpl__Group_4__0__Impl5211); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2364:1: rule__OilObjectImpl__Group_4__1 : rule__OilObjectImpl__Group_4__1__Impl ;
    public final void rule__OilObjectImpl__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2368:1: ( rule__OilObjectImpl__Group_4__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2369:2: rule__OilObjectImpl__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__Group_4__1__Impl_in_rule__OilObjectImpl__Group_4__15242);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2375:1: rule__OilObjectImpl__Group_4__1__Impl : ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) ) ;
    public final void rule__OilObjectImpl__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2379:1: ( ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2380:1: ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2380:1: ( ( rule__OilObjectImpl__DescriptionAssignment_4_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2381:1: ( rule__OilObjectImpl__DescriptionAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getDescriptionAssignment_4_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2382:1: ( rule__OilObjectImpl__DescriptionAssignment_4_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2382:2: rule__OilObjectImpl__DescriptionAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObjectImpl__DescriptionAssignment_4_1_in_rule__OilObjectImpl__Group_4__1__Impl5269);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2396:1: rule__OilApplication__Group__0 : rule__OilApplication__Group__0__Impl rule__OilApplication__Group__1 ;
    public final void rule__OilApplication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2400:1: ( rule__OilApplication__Group__0__Impl rule__OilApplication__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2401:2: rule__OilApplication__Group__0__Impl rule__OilApplication__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__0__Impl_in_rule__OilApplication__Group__05303);
            rule__OilApplication__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__1_in_rule__OilApplication__Group__05306);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2408:1: rule__OilApplication__Group__0__Impl : ( 'CPU' ) ;
    public final void rule__OilApplication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2412:1: ( ( 'CPU' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2413:1: ( 'CPU' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2413:1: ( 'CPU' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2414:1: 'CPU'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getCPUKeyword_0()); 
            }
            match(input,63,FollowSets000.FOLLOW_63_in_rule__OilApplication__Group__0__Impl5334); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2427:1: rule__OilApplication__Group__1 : rule__OilApplication__Group__1__Impl rule__OilApplication__Group__2 ;
    public final void rule__OilApplication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2431:1: ( rule__OilApplication__Group__1__Impl rule__OilApplication__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2432:2: rule__OilApplication__Group__1__Impl rule__OilApplication__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__1__Impl_in_rule__OilApplication__Group__15365);
            rule__OilApplication__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__2_in_rule__OilApplication__Group__15368);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2439:1: rule__OilApplication__Group__1__Impl : ( ( rule__OilApplication__NameAssignment_1 ) ) ;
    public final void rule__OilApplication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2443:1: ( ( ( rule__OilApplication__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2444:1: ( ( rule__OilApplication__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2444:1: ( ( rule__OilApplication__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2445:1: ( rule__OilApplication__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2446:1: ( rule__OilApplication__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2446:2: rule__OilApplication__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__NameAssignment_1_in_rule__OilApplication__Group__1__Impl5395);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2456:1: rule__OilApplication__Group__2 : rule__OilApplication__Group__2__Impl rule__OilApplication__Group__3 ;
    public final void rule__OilApplication__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2460:1: ( rule__OilApplication__Group__2__Impl rule__OilApplication__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2461:2: rule__OilApplication__Group__2__Impl rule__OilApplication__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__2__Impl_in_rule__OilApplication__Group__25425);
            rule__OilApplication__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__3_in_rule__OilApplication__Group__25428);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2468:1: rule__OilApplication__Group__2__Impl : ( '{' ) ;
    public final void rule__OilApplication__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2472:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2473:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2473:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2474:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,60,FollowSets000.FOLLOW_60_in_rule__OilApplication__Group__2__Impl5456); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2487:1: rule__OilApplication__Group__3 : rule__OilApplication__Group__3__Impl rule__OilApplication__Group__4 ;
    public final void rule__OilApplication__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2491:1: ( rule__OilApplication__Group__3__Impl rule__OilApplication__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2492:2: rule__OilApplication__Group__3__Impl rule__OilApplication__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__3__Impl_in_rule__OilApplication__Group__35487);
            rule__OilApplication__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__4_in_rule__OilApplication__Group__35490);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2499:1: rule__OilApplication__Group__3__Impl : ( ( rule__OilApplication__OilObjectsAssignment_3 )* ) ;
    public final void rule__OilApplication__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2503:1: ( ( ( rule__OilApplication__OilObjectsAssignment_3 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2504:1: ( ( rule__OilApplication__OilObjectsAssignment_3 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2504:1: ( ( rule__OilApplication__OilObjectsAssignment_3 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2505:1: ( rule__OilApplication__OilObjectsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getOilObjectsAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2506:1: ( rule__OilApplication__OilObjectsAssignment_3 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=22 && LA28_0<=36)||LA28_0==54) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2506:2: rule__OilApplication__OilObjectsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilApplication__OilObjectsAssignment_3_in_rule__OilApplication__Group__3__Impl5517);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2516:1: rule__OilApplication__Group__4 : rule__OilApplication__Group__4__Impl rule__OilApplication__Group__5 ;
    public final void rule__OilApplication__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2520:1: ( rule__OilApplication__Group__4__Impl rule__OilApplication__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2521:2: rule__OilApplication__Group__4__Impl rule__OilApplication__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__4__Impl_in_rule__OilApplication__Group__45548);
            rule__OilApplication__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__5_in_rule__OilApplication__Group__45551);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2528:1: rule__OilApplication__Group__4__Impl : ( '}' ) ;
    public final void rule__OilApplication__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2532:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2533:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2533:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2534:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,61,FollowSets000.FOLLOW_61_in_rule__OilApplication__Group__4__Impl5579); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2547:1: rule__OilApplication__Group__5 : rule__OilApplication__Group__5__Impl rule__OilApplication__Group__6 ;
    public final void rule__OilApplication__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2551:1: ( rule__OilApplication__Group__5__Impl rule__OilApplication__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2552:2: rule__OilApplication__Group__5__Impl rule__OilApplication__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__5__Impl_in_rule__OilApplication__Group__55610);
            rule__OilApplication__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__6_in_rule__OilApplication__Group__55613);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2559:1: rule__OilApplication__Group__5__Impl : ( ( rule__OilApplication__Group_5__0 )? ) ;
    public final void rule__OilApplication__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2563:1: ( ( ( rule__OilApplication__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2564:1: ( ( rule__OilApplication__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2564:1: ( ( rule__OilApplication__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2565:1: ( rule__OilApplication__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2566:1: ( rule__OilApplication__Group_5__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==62) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2566:2: rule__OilApplication__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__0_in_rule__OilApplication__Group__5__Impl5640);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2576:1: rule__OilApplication__Group__6 : rule__OilApplication__Group__6__Impl ;
    public final void rule__OilApplication__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2580:1: ( rule__OilApplication__Group__6__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2581:2: rule__OilApplication__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group__6__Impl_in_rule__OilApplication__Group__65671);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2587:1: rule__OilApplication__Group__6__Impl : ( ';' ) ;
    public final void rule__OilApplication__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2591:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2592:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2592:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2593:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getSemicolonKeyword_6()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__OilApplication__Group__6__Impl5699); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2620:1: rule__OilApplication__Group_5__0 : rule__OilApplication__Group_5__0__Impl rule__OilApplication__Group_5__1 ;
    public final void rule__OilApplication__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2624:1: ( rule__OilApplication__Group_5__0__Impl rule__OilApplication__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2625:2: rule__OilApplication__Group_5__0__Impl rule__OilApplication__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__0__Impl_in_rule__OilApplication__Group_5__05744);
            rule__OilApplication__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__1_in_rule__OilApplication__Group_5__05747);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2632:1: rule__OilApplication__Group_5__0__Impl : ( ':' ) ;
    public final void rule__OilApplication__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2636:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2637:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2637:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2638:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getColonKeyword_5_0()); 
            }
            match(input,62,FollowSets000.FOLLOW_62_in_rule__OilApplication__Group_5__0__Impl5775); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2651:1: rule__OilApplication__Group_5__1 : rule__OilApplication__Group_5__1__Impl ;
    public final void rule__OilApplication__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2655:1: ( rule__OilApplication__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2656:2: rule__OilApplication__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__Group_5__1__Impl_in_rule__OilApplication__Group_5__15806);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2662:1: rule__OilApplication__Group_5__1__Impl : ( ( rule__OilApplication__DescriptionAssignment_5_1 ) ) ;
    public final void rule__OilApplication__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2666:1: ( ( ( rule__OilApplication__DescriptionAssignment_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2667:1: ( ( rule__OilApplication__DescriptionAssignment_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2667:1: ( ( rule__OilApplication__DescriptionAssignment_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2668:1: ( rule__OilApplication__DescriptionAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getDescriptionAssignment_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2669:1: ( rule__OilApplication__DescriptionAssignment_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2669:2: rule__OilApplication__DescriptionAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilApplication__DescriptionAssignment_5_1_in_rule__OilApplication__Group_5__1__Impl5833);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2683:1: rule__ValueList__Group__0 : rule__ValueList__Group__0__Impl rule__ValueList__Group__1 ;
    public final void rule__ValueList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2687:1: ( rule__ValueList__Group__0__Impl rule__ValueList__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2688:2: rule__ValueList__Group__0__Impl rule__ValueList__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group__0__Impl_in_rule__ValueList__Group__05867);
            rule__ValueList__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group__1_in_rule__ValueList__Group__05870);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2695:1: rule__ValueList__Group__0__Impl : ( () ) ;
    public final void rule__ValueList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2699:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2700:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2700:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2701:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueListAccess().getValueListAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2702:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2704:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2714:1: rule__ValueList__Group__1 : rule__ValueList__Group__1__Impl rule__ValueList__Group__2 ;
    public final void rule__ValueList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2718:1: ( rule__ValueList__Group__1__Impl rule__ValueList__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2719:2: rule__ValueList__Group__1__Impl rule__ValueList__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group__1__Impl_in_rule__ValueList__Group__15928);
            rule__ValueList__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group__2_in_rule__ValueList__Group__15931);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2726:1: rule__ValueList__Group__1__Impl : ( ( rule__ValueList__ValuesAssignment_1 ) ) ;
    public final void rule__ValueList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2730:1: ( ( ( rule__ValueList__ValuesAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2731:1: ( ( rule__ValueList__ValuesAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2731:1: ( ( rule__ValueList__ValuesAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2732:1: ( rule__ValueList__ValuesAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueListAccess().getValuesAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2733:1: ( rule__ValueList__ValuesAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2733:2: rule__ValueList__ValuesAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__ValuesAssignment_1_in_rule__ValueList__Group__1__Impl5958);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2743:1: rule__ValueList__Group__2 : rule__ValueList__Group__2__Impl ;
    public final void rule__ValueList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2747:1: ( rule__ValueList__Group__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2748:2: rule__ValueList__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group__2__Impl_in_rule__ValueList__Group__25988);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2754:1: rule__ValueList__Group__2__Impl : ( ( rule__ValueList__Group_2__0 )* ) ;
    public final void rule__ValueList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2758:1: ( ( ( rule__ValueList__Group_2__0 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2759:1: ( ( rule__ValueList__Group_2__0 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2759:1: ( ( rule__ValueList__Group_2__0 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2760:1: ( rule__ValueList__Group_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueListAccess().getGroup_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2761:1: ( rule__ValueList__Group_2__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==64) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2761:2: rule__ValueList__Group_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group_2__0_in_rule__ValueList__Group__2__Impl6015);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2777:1: rule__ValueList__Group_2__0 : rule__ValueList__Group_2__0__Impl rule__ValueList__Group_2__1 ;
    public final void rule__ValueList__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2781:1: ( rule__ValueList__Group_2__0__Impl rule__ValueList__Group_2__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2782:2: rule__ValueList__Group_2__0__Impl rule__ValueList__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group_2__0__Impl_in_rule__ValueList__Group_2__06052);
            rule__ValueList__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group_2__1_in_rule__ValueList__Group_2__06055);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2789:1: rule__ValueList__Group_2__0__Impl : ( ',' ) ;
    public final void rule__ValueList__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2793:1: ( ( ',' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2794:1: ( ',' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2794:1: ( ',' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2795:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueListAccess().getCommaKeyword_2_0()); 
            }
            match(input,64,FollowSets000.FOLLOW_64_in_rule__ValueList__Group_2__0__Impl6083); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2808:1: rule__ValueList__Group_2__1 : rule__ValueList__Group_2__1__Impl ;
    public final void rule__ValueList__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2812:1: ( rule__ValueList__Group_2__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2813:2: rule__ValueList__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__Group_2__1__Impl_in_rule__ValueList__Group_2__16114);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2819:1: rule__ValueList__Group_2__1__Impl : ( ( rule__ValueList__ValuesAssignment_2_1 ) ) ;
    public final void rule__ValueList__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2823:1: ( ( ( rule__ValueList__ValuesAssignment_2_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2824:1: ( ( rule__ValueList__ValuesAssignment_2_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2824:1: ( ( rule__ValueList__ValuesAssignment_2_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2825:1: ( rule__ValueList__ValuesAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueListAccess().getValuesAssignment_2_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2826:1: ( rule__ValueList__ValuesAssignment_2_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2826:2: rule__ValueList__ValuesAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueList__ValuesAssignment_2_1_in_rule__ValueList__Group_2__1__Impl6141);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2840:1: rule__Range__Group__0 : rule__Range__Group__0__Impl rule__Range__Group__1 ;
    public final void rule__Range__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2844:1: ( rule__Range__Group__0__Impl rule__Range__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2845:2: rule__Range__Group__0__Impl rule__Range__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Range__Group__0__Impl_in_rule__Range__Group__06175);
            rule__Range__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Range__Group__1_in_rule__Range__Group__06178);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2852:1: rule__Range__Group__0__Impl : ( () ) ;
    public final void rule__Range__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2856:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2857:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2857:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2858:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getRangeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2859:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2861:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2871:1: rule__Range__Group__1 : rule__Range__Group__1__Impl rule__Range__Group__2 ;
    public final void rule__Range__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2875:1: ( rule__Range__Group__1__Impl rule__Range__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2876:2: rule__Range__Group__1__Impl rule__Range__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Range__Group__1__Impl_in_rule__Range__Group__16236);
            rule__Range__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Range__Group__2_in_rule__Range__Group__16239);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2883:1: rule__Range__Group__1__Impl : ( ( rule__Range__MinAssignment_1 ) ) ;
    public final void rule__Range__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2887:1: ( ( ( rule__Range__MinAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2888:1: ( ( rule__Range__MinAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2888:1: ( ( rule__Range__MinAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2889:1: ( rule__Range__MinAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getMinAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2890:1: ( rule__Range__MinAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2890:2: rule__Range__MinAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Range__MinAssignment_1_in_rule__Range__Group__1__Impl6266);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2900:1: rule__Range__Group__2 : rule__Range__Group__2__Impl rule__Range__Group__3 ;
    public final void rule__Range__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2904:1: ( rule__Range__Group__2__Impl rule__Range__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2905:2: rule__Range__Group__2__Impl rule__Range__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Range__Group__2__Impl_in_rule__Range__Group__26296);
            rule__Range__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Range__Group__3_in_rule__Range__Group__26299);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2912:1: rule__Range__Group__2__Impl : ( '..' ) ;
    public final void rule__Range__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2916:1: ( ( '..' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2917:1: ( '..' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2917:1: ( '..' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2918:1: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getFullStopFullStopKeyword_2()); 
            }
            match(input,65,FollowSets000.FOLLOW_65_in_rule__Range__Group__2__Impl6327); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2931:1: rule__Range__Group__3 : rule__Range__Group__3__Impl ;
    public final void rule__Range__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2935:1: ( rule__Range__Group__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2936:2: rule__Range__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Range__Group__3__Impl_in_rule__Range__Group__36358);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2942:1: rule__Range__Group__3__Impl : ( ( rule__Range__MaxAssignment_3 ) ) ;
    public final void rule__Range__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2946:1: ( ( ( rule__Range__MaxAssignment_3 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2947:1: ( ( rule__Range__MaxAssignment_3 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2947:1: ( ( rule__Range__MaxAssignment_3 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2948:1: ( rule__Range__MaxAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getMaxAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2949:1: ( rule__Range__MaxAssignment_3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2949:2: rule__Range__MaxAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Range__MaxAssignment_3_in_rule__Range__Group__3__Impl6385);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2967:1: rule__ValueType__Group__0 : rule__ValueType__Group__0__Impl rule__ValueType__Group__1 ;
    public final void rule__ValueType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2971:1: ( rule__ValueType__Group__0__Impl rule__ValueType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2972:2: rule__ValueType__Group__0__Impl rule__ValueType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__0__Impl_in_rule__ValueType__Group__06423);
            rule__ValueType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__1_in_rule__ValueType__Group__06426);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2979:1: rule__ValueType__Group__0__Impl : ( () ) ;
    public final void rule__ValueType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2983:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2984:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2984:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2985:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getValueTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2986:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2988:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:2998:1: rule__ValueType__Group__1 : rule__ValueType__Group__1__Impl rule__ValueType__Group__2 ;
    public final void rule__ValueType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3002:1: ( rule__ValueType__Group__1__Impl rule__ValueType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3003:2: rule__ValueType__Group__1__Impl rule__ValueType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__1__Impl_in_rule__ValueType__Group__16484);
            rule__ValueType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__2_in_rule__ValueType__Group__16487);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3010:1: rule__ValueType__Group__1__Impl : ( ( rule__ValueType__TypeAssignment_1 ) ) ;
    public final void rule__ValueType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3014:1: ( ( ( rule__ValueType__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3015:1: ( ( rule__ValueType__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3015:1: ( ( rule__ValueType__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3016:1: ( rule__ValueType__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3017:1: ( rule__ValueType__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3017:2: rule__ValueType__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__TypeAssignment_1_in_rule__ValueType__Group__1__Impl6514);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3027:1: rule__ValueType__Group__2 : rule__ValueType__Group__2__Impl rule__ValueType__Group__3 ;
    public final void rule__ValueType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3031:1: ( rule__ValueType__Group__2__Impl rule__ValueType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3032:2: rule__ValueType__Group__2__Impl rule__ValueType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__2__Impl_in_rule__ValueType__Group__26544);
            rule__ValueType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__3_in_rule__ValueType__Group__26547);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3039:1: rule__ValueType__Group__2__Impl : ( ( rule__ValueType__WithAutoAssignment_2 )? ) ;
    public final void rule__ValueType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3043:1: ( ( ( rule__ValueType__WithAutoAssignment_2 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3044:1: ( ( rule__ValueType__WithAutoAssignment_2 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3044:1: ( ( rule__ValueType__WithAutoAssignment_2 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3045:1: ( rule__ValueType__WithAutoAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getWithAutoAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3046:1: ( rule__ValueType__WithAutoAssignment_2 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==69) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3046:2: rule__ValueType__WithAutoAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__WithAutoAssignment_2_in_rule__ValueType__Group__2__Impl6574);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3056:1: rule__ValueType__Group__3 : rule__ValueType__Group__3__Impl rule__ValueType__Group__4 ;
    public final void rule__ValueType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3060:1: ( rule__ValueType__Group__3__Impl rule__ValueType__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3061:2: rule__ValueType__Group__3__Impl rule__ValueType__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__3__Impl_in_rule__ValueType__Group__36605);
            rule__ValueType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__4_in_rule__ValueType__Group__36608);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3068:1: rule__ValueType__Group__3__Impl : ( ( rule__ValueType__Group_3__0 )? ) ;
    public final void rule__ValueType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3072:1: ( ( ( rule__ValueType__Group_3__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3073:1: ( ( rule__ValueType__Group_3__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3073:1: ( ( rule__ValueType__Group_3__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3074:1: ( rule__ValueType__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getGroup_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3075:1: ( rule__ValueType__Group_3__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==66) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3075:2: rule__ValueType__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3__0_in_rule__ValueType__Group__3__Impl6635);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3085:1: rule__ValueType__Group__4 : rule__ValueType__Group__4__Impl rule__ValueType__Group__5 ;
    public final void rule__ValueType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3089:1: ( rule__ValueType__Group__4__Impl rule__ValueType__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3090:2: rule__ValueType__Group__4__Impl rule__ValueType__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__4__Impl_in_rule__ValueType__Group__46666);
            rule__ValueType__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__5_in_rule__ValueType__Group__46669);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3097:1: rule__ValueType__Group__4__Impl : ( ( rule__ValueType__NameAssignment_4 ) ) ;
    public final void rule__ValueType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3101:1: ( ( ( rule__ValueType__NameAssignment_4 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3102:1: ( ( rule__ValueType__NameAssignment_4 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3102:1: ( ( rule__ValueType__NameAssignment_4 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3103:1: ( rule__ValueType__NameAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getNameAssignment_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3104:1: ( rule__ValueType__NameAssignment_4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3104:2: rule__ValueType__NameAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__NameAssignment_4_in_rule__ValueType__Group__4__Impl6696);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3114:1: rule__ValueType__Group__5 : rule__ValueType__Group__5__Impl rule__ValueType__Group__6 ;
    public final void rule__ValueType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3118:1: ( rule__ValueType__Group__5__Impl rule__ValueType__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3119:2: rule__ValueType__Group__5__Impl rule__ValueType__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__5__Impl_in_rule__ValueType__Group__56726);
            rule__ValueType__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__6_in_rule__ValueType__Group__56729);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3126:1: rule__ValueType__Group__5__Impl : ( ( rule__ValueType__MultiValueAssignment_5 )? ) ;
    public final void rule__ValueType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3130:1: ( ( ( rule__ValueType__MultiValueAssignment_5 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3131:1: ( ( rule__ValueType__MultiValueAssignment_5 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3131:1: ( ( rule__ValueType__MultiValueAssignment_5 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3132:1: ( rule__ValueType__MultiValueAssignment_5 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMultiValueAssignment_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3133:1: ( rule__ValueType__MultiValueAssignment_5 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==70) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3133:2: rule__ValueType__MultiValueAssignment_5
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__MultiValueAssignment_5_in_rule__ValueType__Group__5__Impl6756);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3143:1: rule__ValueType__Group__6 : rule__ValueType__Group__6__Impl rule__ValueType__Group__7 ;
    public final void rule__ValueType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3147:1: ( rule__ValueType__Group__6__Impl rule__ValueType__Group__7 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3148:2: rule__ValueType__Group__6__Impl rule__ValueType__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__6__Impl_in_rule__ValueType__Group__66787);
            rule__ValueType__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__7_in_rule__ValueType__Group__66790);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3155:1: rule__ValueType__Group__6__Impl : ( ( rule__ValueType__Group_6__0 )? ) ;
    public final void rule__ValueType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3159:1: ( ( ( rule__ValueType__Group_6__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3160:1: ( ( rule__ValueType__Group_6__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3160:1: ( ( rule__ValueType__Group_6__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3161:1: ( rule__ValueType__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getGroup_6()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3162:1: ( rule__ValueType__Group_6__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==57) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3162:2: rule__ValueType__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__0_in_rule__ValueType__Group__6__Impl6817);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3172:1: rule__ValueType__Group__7 : rule__ValueType__Group__7__Impl rule__ValueType__Group__8 ;
    public final void rule__ValueType__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3176:1: ( rule__ValueType__Group__7__Impl rule__ValueType__Group__8 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3177:2: rule__ValueType__Group__7__Impl rule__ValueType__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__7__Impl_in_rule__ValueType__Group__76848);
            rule__ValueType__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__8_in_rule__ValueType__Group__76851);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3184:1: rule__ValueType__Group__7__Impl : ( ( rule__ValueType__Group_7__0 )? ) ;
    public final void rule__ValueType__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3188:1: ( ( ( rule__ValueType__Group_7__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3189:1: ( ( rule__ValueType__Group_7__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3189:1: ( ( rule__ValueType__Group_7__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3190:1: ( rule__ValueType__Group_7__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getGroup_7()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3191:1: ( rule__ValueType__Group_7__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==62) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3191:2: rule__ValueType__Group_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_7__0_in_rule__ValueType__Group__7__Impl6878);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3201:1: rule__ValueType__Group__8 : rule__ValueType__Group__8__Impl ;
    public final void rule__ValueType__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3205:1: ( rule__ValueType__Group__8__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3206:2: rule__ValueType__Group__8__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group__8__Impl_in_rule__ValueType__Group__86909);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3212:1: rule__ValueType__Group__8__Impl : ( ';' ) ;
    public final void rule__ValueType__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3216:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3217:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3217:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3218:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getSemicolonKeyword_8()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__ValueType__Group__8__Impl6937); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3249:1: rule__ValueType__Group_3__0 : rule__ValueType__Group_3__0__Impl rule__ValueType__Group_3__1 ;
    public final void rule__ValueType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3253:1: ( rule__ValueType__Group_3__0__Impl rule__ValueType__Group_3__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3254:2: rule__ValueType__Group_3__0__Impl rule__ValueType__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3__0__Impl_in_rule__ValueType__Group_3__06986);
            rule__ValueType__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3__1_in_rule__ValueType__Group_3__06989);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3261:1: rule__ValueType__Group_3__0__Impl : ( '[' ) ;
    public final void rule__ValueType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3265:1: ( ( '[' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3266:1: ( '[' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3266:1: ( '[' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3267:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getLeftSquareBracketKeyword_3_0()); 
            }
            match(input,66,FollowSets000.FOLLOW_66_in_rule__ValueType__Group_3__0__Impl7017); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3280:1: rule__ValueType__Group_3__1 : rule__ValueType__Group_3__1__Impl rule__ValueType__Group_3__2 ;
    public final void rule__ValueType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3284:1: ( rule__ValueType__Group_3__1__Impl rule__ValueType__Group_3__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3285:2: rule__ValueType__Group_3__1__Impl rule__ValueType__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3__1__Impl_in_rule__ValueType__Group_3__17048);
            rule__ValueType__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3__2_in_rule__ValueType__Group_3__17051);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3292:1: rule__ValueType__Group_3__1__Impl : ( ( rule__ValueType__ValidValuesAssignment_3_1 ) ) ;
    public final void rule__ValueType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3296:1: ( ( ( rule__ValueType__ValidValuesAssignment_3_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3297:1: ( ( rule__ValueType__ValidValuesAssignment_3_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3297:1: ( ( rule__ValueType__ValidValuesAssignment_3_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3298:1: ( rule__ValueType__ValidValuesAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getValidValuesAssignment_3_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3299:1: ( rule__ValueType__ValidValuesAssignment_3_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3299:2: rule__ValueType__ValidValuesAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__ValidValuesAssignment_3_1_in_rule__ValueType__Group_3__1__Impl7078);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3309:1: rule__ValueType__Group_3__2 : rule__ValueType__Group_3__2__Impl ;
    public final void rule__ValueType__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3313:1: ( rule__ValueType__Group_3__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3314:2: rule__ValueType__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_3__2__Impl_in_rule__ValueType__Group_3__27108);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3320:1: rule__ValueType__Group_3__2__Impl : ( ']' ) ;
    public final void rule__ValueType__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3324:1: ( ( ']' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3325:1: ( ']' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3325:1: ( ']' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3326:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getRightSquareBracketKeyword_3_2()); 
            }
            match(input,67,FollowSets000.FOLLOW_67_in_rule__ValueType__Group_3__2__Impl7136); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3345:1: rule__ValueType__Group_6__0 : rule__ValueType__Group_6__0__Impl rule__ValueType__Group_6__1 ;
    public final void rule__ValueType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3349:1: ( rule__ValueType__Group_6__0__Impl rule__ValueType__Group_6__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3350:2: rule__ValueType__Group_6__0__Impl rule__ValueType__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__0__Impl_in_rule__ValueType__Group_6__07173);
            rule__ValueType__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__1_in_rule__ValueType__Group_6__07176);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3357:1: rule__ValueType__Group_6__0__Impl : ( '=' ) ;
    public final void rule__ValueType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3361:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3362:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3362:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3363:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getEqualsSignKeyword_6_0()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__ValueType__Group_6__0__Impl7204); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3376:1: rule__ValueType__Group_6__1 : rule__ValueType__Group_6__1__Impl ;
    public final void rule__ValueType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3380:1: ( rule__ValueType__Group_6__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3381:2: rule__ValueType__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_6__1__Impl_in_rule__ValueType__Group_6__17235);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3387:1: rule__ValueType__Group_6__1__Impl : ( ( rule__ValueType__Alternatives_6_1 ) ) ;
    public final void rule__ValueType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3391:1: ( ( ( rule__ValueType__Alternatives_6_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3392:1: ( ( rule__ValueType__Alternatives_6_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3392:1: ( ( rule__ValueType__Alternatives_6_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3393:1: ( rule__ValueType__Alternatives_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getAlternatives_6_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3394:1: ( rule__ValueType__Alternatives_6_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3394:2: rule__ValueType__Alternatives_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Alternatives_6_1_in_rule__ValueType__Group_6__1__Impl7262);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3408:1: rule__ValueType__Group_7__0 : rule__ValueType__Group_7__0__Impl rule__ValueType__Group_7__1 ;
    public final void rule__ValueType__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3412:1: ( rule__ValueType__Group_7__0__Impl rule__ValueType__Group_7__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3413:2: rule__ValueType__Group_7__0__Impl rule__ValueType__Group_7__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_7__0__Impl_in_rule__ValueType__Group_7__07296);
            rule__ValueType__Group_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_7__1_in_rule__ValueType__Group_7__07299);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3420:1: rule__ValueType__Group_7__0__Impl : ( ':' ) ;
    public final void rule__ValueType__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3424:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3425:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3425:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3426:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getColonKeyword_7_0()); 
            }
            match(input,62,FollowSets000.FOLLOW_62_in_rule__ValueType__Group_7__0__Impl7327); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3439:1: rule__ValueType__Group_7__1 : rule__ValueType__Group_7__1__Impl ;
    public final void rule__ValueType__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3443:1: ( rule__ValueType__Group_7__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3444:2: rule__ValueType__Group_7__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__Group_7__1__Impl_in_rule__ValueType__Group_7__17358);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3450:1: rule__ValueType__Group_7__1__Impl : ( ( rule__ValueType__DescriptionAssignment_7_1 ) ) ;
    public final void rule__ValueType__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3454:1: ( ( ( rule__ValueType__DescriptionAssignment_7_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3455:1: ( ( rule__ValueType__DescriptionAssignment_7_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3455:1: ( ( rule__ValueType__DescriptionAssignment_7_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3456:1: ( rule__ValueType__DescriptionAssignment_7_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDescriptionAssignment_7_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3457:1: ( rule__ValueType__DescriptionAssignment_7_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3457:2: rule__ValueType__DescriptionAssignment_7_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__DescriptionAssignment_7_1_in_rule__ValueType__Group_7__1__Impl7385);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3471:1: rule__VariantType__Group__0 : rule__VariantType__Group__0__Impl rule__VariantType__Group__1 ;
    public final void rule__VariantType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3475:1: ( rule__VariantType__Group__0__Impl rule__VariantType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3476:2: rule__VariantType__Group__0__Impl rule__VariantType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__0__Impl_in_rule__VariantType__Group__07419);
            rule__VariantType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__1_in_rule__VariantType__Group__07422);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3483:1: rule__VariantType__Group__0__Impl : ( () ) ;
    public final void rule__VariantType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3487:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3488:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3488:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3489:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getVariantTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3490:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3492:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3502:1: rule__VariantType__Group__1 : rule__VariantType__Group__1__Impl rule__VariantType__Group__2 ;
    public final void rule__VariantType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3506:1: ( rule__VariantType__Group__1__Impl rule__VariantType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3507:2: rule__VariantType__Group__1__Impl rule__VariantType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__1__Impl_in_rule__VariantType__Group__17480);
            rule__VariantType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__2_in_rule__VariantType__Group__17483);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3514:1: rule__VariantType__Group__1__Impl : ( ( rule__VariantType__TypeAssignment_1 ) ) ;
    public final void rule__VariantType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3518:1: ( ( ( rule__VariantType__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3519:1: ( ( rule__VariantType__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3519:1: ( ( rule__VariantType__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3520:1: ( rule__VariantType__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3521:1: ( rule__VariantType__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3521:2: rule__VariantType__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__TypeAssignment_1_in_rule__VariantType__Group__1__Impl7510);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3531:1: rule__VariantType__Group__2 : rule__VariantType__Group__2__Impl rule__VariantType__Group__3 ;
    public final void rule__VariantType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3535:1: ( rule__VariantType__Group__2__Impl rule__VariantType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3536:2: rule__VariantType__Group__2__Impl rule__VariantType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__2__Impl_in_rule__VariantType__Group__27540);
            rule__VariantType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__3_in_rule__VariantType__Group__27543);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3543:1: rule__VariantType__Group__2__Impl : ( ( rule__VariantType__WithAutoAssignment_2 )? ) ;
    public final void rule__VariantType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3547:1: ( ( ( rule__VariantType__WithAutoAssignment_2 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3548:1: ( ( rule__VariantType__WithAutoAssignment_2 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3548:1: ( ( rule__VariantType__WithAutoAssignment_2 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3549:1: ( rule__VariantType__WithAutoAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getWithAutoAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3550:1: ( rule__VariantType__WithAutoAssignment_2 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==69) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3550:2: rule__VariantType__WithAutoAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__WithAutoAssignment_2_in_rule__VariantType__Group__2__Impl7570);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3560:1: rule__VariantType__Group__3 : rule__VariantType__Group__3__Impl rule__VariantType__Group__4 ;
    public final void rule__VariantType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3564:1: ( rule__VariantType__Group__3__Impl rule__VariantType__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3565:2: rule__VariantType__Group__3__Impl rule__VariantType__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__3__Impl_in_rule__VariantType__Group__37601);
            rule__VariantType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__4_in_rule__VariantType__Group__37604);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3572:1: rule__VariantType__Group__3__Impl : ( ( rule__VariantType__Group_3__0 )? ) ;
    public final void rule__VariantType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3576:1: ( ( ( rule__VariantType__Group_3__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3577:1: ( ( rule__VariantType__Group_3__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3577:1: ( ( rule__VariantType__Group_3__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3578:1: ( rule__VariantType__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3579:1: ( rule__VariantType__Group_3__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==66) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3579:2: rule__VariantType__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__0_in_rule__VariantType__Group__3__Impl7631);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3589:1: rule__VariantType__Group__4 : rule__VariantType__Group__4__Impl rule__VariantType__Group__5 ;
    public final void rule__VariantType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3593:1: ( rule__VariantType__Group__4__Impl rule__VariantType__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3594:2: rule__VariantType__Group__4__Impl rule__VariantType__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__4__Impl_in_rule__VariantType__Group__47662);
            rule__VariantType__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__5_in_rule__VariantType__Group__47665);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3601:1: rule__VariantType__Group__4__Impl : ( ( rule__VariantType__NameAssignment_4 ) ) ;
    public final void rule__VariantType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3605:1: ( ( ( rule__VariantType__NameAssignment_4 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3606:1: ( ( rule__VariantType__NameAssignment_4 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3606:1: ( ( rule__VariantType__NameAssignment_4 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3607:1: ( rule__VariantType__NameAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getNameAssignment_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3608:1: ( rule__VariantType__NameAssignment_4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3608:2: rule__VariantType__NameAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__NameAssignment_4_in_rule__VariantType__Group__4__Impl7692);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3618:1: rule__VariantType__Group__5 : rule__VariantType__Group__5__Impl rule__VariantType__Group__6 ;
    public final void rule__VariantType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3622:1: ( rule__VariantType__Group__5__Impl rule__VariantType__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3623:2: rule__VariantType__Group__5__Impl rule__VariantType__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__5__Impl_in_rule__VariantType__Group__57722);
            rule__VariantType__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__6_in_rule__VariantType__Group__57725);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3630:1: rule__VariantType__Group__5__Impl : ( ( rule__VariantType__MultiValueAssignment_5 )? ) ;
    public final void rule__VariantType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3634:1: ( ( ( rule__VariantType__MultiValueAssignment_5 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3635:1: ( ( rule__VariantType__MultiValueAssignment_5 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3635:1: ( ( rule__VariantType__MultiValueAssignment_5 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3636:1: ( rule__VariantType__MultiValueAssignment_5 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getMultiValueAssignment_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3637:1: ( rule__VariantType__MultiValueAssignment_5 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==70) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3637:2: rule__VariantType__MultiValueAssignment_5
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__MultiValueAssignment_5_in_rule__VariantType__Group__5__Impl7752);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3647:1: rule__VariantType__Group__6 : rule__VariantType__Group__6__Impl rule__VariantType__Group__7 ;
    public final void rule__VariantType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3651:1: ( rule__VariantType__Group__6__Impl rule__VariantType__Group__7 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3652:2: rule__VariantType__Group__6__Impl rule__VariantType__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__6__Impl_in_rule__VariantType__Group__67783);
            rule__VariantType__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__7_in_rule__VariantType__Group__67786);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3659:1: rule__VariantType__Group__6__Impl : ( ( rule__VariantType__Group_6__0 )? ) ;
    public final void rule__VariantType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3663:1: ( ( ( rule__VariantType__Group_6__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3664:1: ( ( rule__VariantType__Group_6__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3664:1: ( ( rule__VariantType__Group_6__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3665:1: ( rule__VariantType__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_6()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3666:1: ( rule__VariantType__Group_6__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==57) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3666:2: rule__VariantType__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__0_in_rule__VariantType__Group__6__Impl7813);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3676:1: rule__VariantType__Group__7 : rule__VariantType__Group__7__Impl rule__VariantType__Group__8 ;
    public final void rule__VariantType__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3680:1: ( rule__VariantType__Group__7__Impl rule__VariantType__Group__8 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3681:2: rule__VariantType__Group__7__Impl rule__VariantType__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__7__Impl_in_rule__VariantType__Group__77844);
            rule__VariantType__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__8_in_rule__VariantType__Group__77847);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3688:1: rule__VariantType__Group__7__Impl : ( ( rule__VariantType__Group_7__0 )? ) ;
    public final void rule__VariantType__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3692:1: ( ( ( rule__VariantType__Group_7__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3693:1: ( ( rule__VariantType__Group_7__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3693:1: ( ( rule__VariantType__Group_7__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3694:1: ( rule__VariantType__Group_7__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_7()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3695:1: ( rule__VariantType__Group_7__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==62) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3695:2: rule__VariantType__Group_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__0_in_rule__VariantType__Group__7__Impl7874);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3705:1: rule__VariantType__Group__8 : rule__VariantType__Group__8__Impl ;
    public final void rule__VariantType__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3709:1: ( rule__VariantType__Group__8__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3710:2: rule__VariantType__Group__8__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group__8__Impl_in_rule__VariantType__Group__87905);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3716:1: rule__VariantType__Group__8__Impl : ( ';' ) ;
    public final void rule__VariantType__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3720:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3721:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3721:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3722:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getSemicolonKeyword_8()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__VariantType__Group__8__Impl7933); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3753:1: rule__VariantType__Group_3__0 : rule__VariantType__Group_3__0__Impl rule__VariantType__Group_3__1 ;
    public final void rule__VariantType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3757:1: ( rule__VariantType__Group_3__0__Impl rule__VariantType__Group_3__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3758:2: rule__VariantType__Group_3__0__Impl rule__VariantType__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__0__Impl_in_rule__VariantType__Group_3__07982);
            rule__VariantType__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__1_in_rule__VariantType__Group_3__07985);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3765:1: rule__VariantType__Group_3__0__Impl : ( '[' ) ;
    public final void rule__VariantType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3769:1: ( ( '[' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3770:1: ( '[' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3770:1: ( '[' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3771:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getLeftSquareBracketKeyword_3_0()); 
            }
            match(input,66,FollowSets000.FOLLOW_66_in_rule__VariantType__Group_3__0__Impl8013); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3784:1: rule__VariantType__Group_3__1 : rule__VariantType__Group_3__1__Impl rule__VariantType__Group_3__2 ;
    public final void rule__VariantType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3788:1: ( rule__VariantType__Group_3__1__Impl rule__VariantType__Group_3__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3789:2: rule__VariantType__Group_3__1__Impl rule__VariantType__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__1__Impl_in_rule__VariantType__Group_3__18044);
            rule__VariantType__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__2_in_rule__VariantType__Group_3__18047);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3796:1: rule__VariantType__Group_3__1__Impl : ( ( rule__VariantType__Group_3_1__0 )? ) ;
    public final void rule__VariantType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3800:1: ( ( ( rule__VariantType__Group_3_1__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3801:1: ( ( rule__VariantType__Group_3_1__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3801:1: ( ( rule__VariantType__Group_3_1__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3802:1: ( rule__VariantType__Group_3_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_3_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3803:1: ( rule__VariantType__Group_3_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID||(LA41_0>=14 && LA41_0<=51)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3803:2: rule__VariantType__Group_3_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1__0_in_rule__VariantType__Group_3__1__Impl8074);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3813:1: rule__VariantType__Group_3__2 : rule__VariantType__Group_3__2__Impl ;
    public final void rule__VariantType__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3817:1: ( rule__VariantType__Group_3__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3818:2: rule__VariantType__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3__2__Impl_in_rule__VariantType__Group_3__28105);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3824:1: rule__VariantType__Group_3__2__Impl : ( ']' ) ;
    public final void rule__VariantType__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3828:1: ( ( ']' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3829:1: ( ']' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3829:1: ( ']' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3830:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getRightSquareBracketKeyword_3_2()); 
            }
            match(input,67,FollowSets000.FOLLOW_67_in_rule__VariantType__Group_3__2__Impl8133); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3849:1: rule__VariantType__Group_3_1__0 : rule__VariantType__Group_3_1__0__Impl rule__VariantType__Group_3_1__1 ;
    public final void rule__VariantType__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3853:1: ( rule__VariantType__Group_3_1__0__Impl rule__VariantType__Group_3_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3854:2: rule__VariantType__Group_3_1__0__Impl rule__VariantType__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1__0__Impl_in_rule__VariantType__Group_3_1__08170);
            rule__VariantType__Group_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1__1_in_rule__VariantType__Group_3_1__08173);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3861:1: rule__VariantType__Group_3_1__0__Impl : ( ( rule__VariantType__ValuesAssignment_3_1_0 ) ) ;
    public final void rule__VariantType__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3865:1: ( ( ( rule__VariantType__ValuesAssignment_3_1_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3866:1: ( ( rule__VariantType__ValuesAssignment_3_1_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3866:1: ( ( rule__VariantType__ValuesAssignment_3_1_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3867:1: ( rule__VariantType__ValuesAssignment_3_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesAssignment_3_1_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3868:1: ( rule__VariantType__ValuesAssignment_3_1_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3868:2: rule__VariantType__ValuesAssignment_3_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__ValuesAssignment_3_1_0_in_rule__VariantType__Group_3_1__0__Impl8200);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3878:1: rule__VariantType__Group_3_1__1 : rule__VariantType__Group_3_1__1__Impl ;
    public final void rule__VariantType__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3882:1: ( rule__VariantType__Group_3_1__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3883:2: rule__VariantType__Group_3_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1__1__Impl_in_rule__VariantType__Group_3_1__18230);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3889:1: rule__VariantType__Group_3_1__1__Impl : ( ( rule__VariantType__Group_3_1_1__0 )* ) ;
    public final void rule__VariantType__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3893:1: ( ( ( rule__VariantType__Group_3_1_1__0 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3894:1: ( ( rule__VariantType__Group_3_1_1__0 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3894:1: ( ( rule__VariantType__Group_3_1_1__0 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3895:1: ( rule__VariantType__Group_3_1_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getGroup_3_1_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3896:1: ( rule__VariantType__Group_3_1_1__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==64) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3896:2: rule__VariantType__Group_3_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1_1__0_in_rule__VariantType__Group_3_1__1__Impl8257);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3910:1: rule__VariantType__Group_3_1_1__0 : rule__VariantType__Group_3_1_1__0__Impl rule__VariantType__Group_3_1_1__1 ;
    public final void rule__VariantType__Group_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3914:1: ( rule__VariantType__Group_3_1_1__0__Impl rule__VariantType__Group_3_1_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3915:2: rule__VariantType__Group_3_1_1__0__Impl rule__VariantType__Group_3_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1_1__0__Impl_in_rule__VariantType__Group_3_1_1__08292);
            rule__VariantType__Group_3_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1_1__1_in_rule__VariantType__Group_3_1_1__08295);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3922:1: rule__VariantType__Group_3_1_1__0__Impl : ( ',' ) ;
    public final void rule__VariantType__Group_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3926:1: ( ( ',' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3927:1: ( ',' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3927:1: ( ',' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3928:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getCommaKeyword_3_1_1_0()); 
            }
            match(input,64,FollowSets000.FOLLOW_64_in_rule__VariantType__Group_3_1_1__0__Impl8323); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3941:1: rule__VariantType__Group_3_1_1__1 : rule__VariantType__Group_3_1_1__1__Impl ;
    public final void rule__VariantType__Group_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3945:1: ( rule__VariantType__Group_3_1_1__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3946:2: rule__VariantType__Group_3_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_3_1_1__1__Impl_in_rule__VariantType__Group_3_1_1__18354);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3952:1: rule__VariantType__Group_3_1_1__1__Impl : ( ( rule__VariantType__ValuesAssignment_3_1_1_1 ) ) ;
    public final void rule__VariantType__Group_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3956:1: ( ( ( rule__VariantType__ValuesAssignment_3_1_1_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3957:1: ( ( rule__VariantType__ValuesAssignment_3_1_1_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3957:1: ( ( rule__VariantType__ValuesAssignment_3_1_1_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3958:1: ( rule__VariantType__ValuesAssignment_3_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesAssignment_3_1_1_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3959:1: ( rule__VariantType__ValuesAssignment_3_1_1_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3959:2: rule__VariantType__ValuesAssignment_3_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__ValuesAssignment_3_1_1_1_in_rule__VariantType__Group_3_1_1__1__Impl8381);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3973:1: rule__VariantType__Group_6__0 : rule__VariantType__Group_6__0__Impl rule__VariantType__Group_6__1 ;
    public final void rule__VariantType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3977:1: ( rule__VariantType__Group_6__0__Impl rule__VariantType__Group_6__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3978:2: rule__VariantType__Group_6__0__Impl rule__VariantType__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__0__Impl_in_rule__VariantType__Group_6__08415);
            rule__VariantType__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__1_in_rule__VariantType__Group_6__08418);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3985:1: rule__VariantType__Group_6__0__Impl : ( '=' ) ;
    public final void rule__VariantType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3989:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3990:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3990:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:3991:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getEqualsSignKeyword_6_0()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__VariantType__Group_6__0__Impl8446); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4004:1: rule__VariantType__Group_6__1 : rule__VariantType__Group_6__1__Impl ;
    public final void rule__VariantType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4008:1: ( rule__VariantType__Group_6__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4009:2: rule__VariantType__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_6__1__Impl_in_rule__VariantType__Group_6__18477);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4015:1: rule__VariantType__Group_6__1__Impl : ( ( rule__VariantType__Alternatives_6_1 ) ) ;
    public final void rule__VariantType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4019:1: ( ( ( rule__VariantType__Alternatives_6_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4020:1: ( ( rule__VariantType__Alternatives_6_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4020:1: ( ( rule__VariantType__Alternatives_6_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4021:1: ( rule__VariantType__Alternatives_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getAlternatives_6_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4022:1: ( rule__VariantType__Alternatives_6_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4022:2: rule__VariantType__Alternatives_6_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Alternatives_6_1_in_rule__VariantType__Group_6__1__Impl8504);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4036:1: rule__VariantType__Group_7__0 : rule__VariantType__Group_7__0__Impl rule__VariantType__Group_7__1 ;
    public final void rule__VariantType__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4040:1: ( rule__VariantType__Group_7__0__Impl rule__VariantType__Group_7__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4041:2: rule__VariantType__Group_7__0__Impl rule__VariantType__Group_7__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__0__Impl_in_rule__VariantType__Group_7__08538);
            rule__VariantType__Group_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__1_in_rule__VariantType__Group_7__08541);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4048:1: rule__VariantType__Group_7__0__Impl : ( ':' ) ;
    public final void rule__VariantType__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4052:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4053:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4053:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4054:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getColonKeyword_7_0()); 
            }
            match(input,62,FollowSets000.FOLLOW_62_in_rule__VariantType__Group_7__0__Impl8569); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4067:1: rule__VariantType__Group_7__1 : rule__VariantType__Group_7__1__Impl ;
    public final void rule__VariantType__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4071:1: ( rule__VariantType__Group_7__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4072:2: rule__VariantType__Group_7__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__Group_7__1__Impl_in_rule__VariantType__Group_7__18600);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4078:1: rule__VariantType__Group_7__1__Impl : ( ( rule__VariantType__DescriptionAssignment_7_1 ) ) ;
    public final void rule__VariantType__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4082:1: ( ( ( rule__VariantType__DescriptionAssignment_7_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4083:1: ( ( rule__VariantType__DescriptionAssignment_7_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4083:1: ( ( rule__VariantType__DescriptionAssignment_7_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4084:1: ( rule__VariantType__DescriptionAssignment_7_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDescriptionAssignment_7_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4085:1: ( rule__VariantType__DescriptionAssignment_7_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4085:2: rule__VariantType__DescriptionAssignment_7_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariantType__DescriptionAssignment_7_1_in_rule__VariantType__Group_7__1__Impl8627);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4099:1: rule__EnumeratorType__Group__0 : rule__EnumeratorType__Group__0__Impl rule__EnumeratorType__Group__1 ;
    public final void rule__EnumeratorType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4103:1: ( rule__EnumeratorType__Group__0__Impl rule__EnumeratorType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4104:2: rule__EnumeratorType__Group__0__Impl rule__EnumeratorType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__0__Impl_in_rule__EnumeratorType__Group__08661);
            rule__EnumeratorType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__1_in_rule__EnumeratorType__Group__08664);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4111:1: rule__EnumeratorType__Group__0__Impl : ( () ) ;
    public final void rule__EnumeratorType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4115:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4116:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4116:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4117:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getEnumeratorTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4118:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4120:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4130:1: rule__EnumeratorType__Group__1 : rule__EnumeratorType__Group__1__Impl rule__EnumeratorType__Group__2 ;
    public final void rule__EnumeratorType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4134:1: ( rule__EnumeratorType__Group__1__Impl rule__EnumeratorType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4135:2: rule__EnumeratorType__Group__1__Impl rule__EnumeratorType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__1__Impl_in_rule__EnumeratorType__Group__18722);
            rule__EnumeratorType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__2_in_rule__EnumeratorType__Group__18725);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4142:1: rule__EnumeratorType__Group__1__Impl : ( ( rule__EnumeratorType__NameAssignment_1 ) ) ;
    public final void rule__EnumeratorType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4146:1: ( ( ( rule__EnumeratorType__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4147:1: ( ( rule__EnumeratorType__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4147:1: ( ( rule__EnumeratorType__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4148:1: ( rule__EnumeratorType__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4149:1: ( rule__EnumeratorType__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4149:2: rule__EnumeratorType__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__NameAssignment_1_in_rule__EnumeratorType__Group__1__Impl8752);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4159:1: rule__EnumeratorType__Group__2 : rule__EnumeratorType__Group__2__Impl rule__EnumeratorType__Group__3 ;
    public final void rule__EnumeratorType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4163:1: ( rule__EnumeratorType__Group__2__Impl rule__EnumeratorType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4164:2: rule__EnumeratorType__Group__2__Impl rule__EnumeratorType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__2__Impl_in_rule__EnumeratorType__Group__28782);
            rule__EnumeratorType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__3_in_rule__EnumeratorType__Group__28785);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4171:1: rule__EnumeratorType__Group__2__Impl : ( ( rule__EnumeratorType__Group_2__0 )? ) ;
    public final void rule__EnumeratorType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4175:1: ( ( ( rule__EnumeratorType__Group_2__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4176:1: ( ( rule__EnumeratorType__Group_2__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4176:1: ( ( rule__EnumeratorType__Group_2__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4177:1: ( rule__EnumeratorType__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getGroup_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4178:1: ( rule__EnumeratorType__Group_2__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==60) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4178:2: rule__EnumeratorType__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__0_in_rule__EnumeratorType__Group__2__Impl8812);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4188:1: rule__EnumeratorType__Group__3 : rule__EnumeratorType__Group__3__Impl ;
    public final void rule__EnumeratorType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4192:1: ( rule__EnumeratorType__Group__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4193:2: rule__EnumeratorType__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group__3__Impl_in_rule__EnumeratorType__Group__38843);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4199:1: rule__EnumeratorType__Group__3__Impl : ( ( rule__EnumeratorType__Group_3__0 )? ) ;
    public final void rule__EnumeratorType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4203:1: ( ( ( rule__EnumeratorType__Group_3__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4204:1: ( ( rule__EnumeratorType__Group_3__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4204:1: ( ( rule__EnumeratorType__Group_3__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4205:1: ( rule__EnumeratorType__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getGroup_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4206:1: ( rule__EnumeratorType__Group_3__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==62) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4206:2: rule__EnumeratorType__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__0_in_rule__EnumeratorType__Group__3__Impl8870);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4224:1: rule__EnumeratorType__Group_2__0 : rule__EnumeratorType__Group_2__0__Impl rule__EnumeratorType__Group_2__1 ;
    public final void rule__EnumeratorType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4228:1: ( rule__EnumeratorType__Group_2__0__Impl rule__EnumeratorType__Group_2__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4229:2: rule__EnumeratorType__Group_2__0__Impl rule__EnumeratorType__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__0__Impl_in_rule__EnumeratorType__Group_2__08909);
            rule__EnumeratorType__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__1_in_rule__EnumeratorType__Group_2__08912);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4236:1: rule__EnumeratorType__Group_2__0__Impl : ( '{' ) ;
    public final void rule__EnumeratorType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4240:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4241:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4241:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4242:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getLeftCurlyBracketKeyword_2_0()); 
            }
            match(input,60,FollowSets000.FOLLOW_60_in_rule__EnumeratorType__Group_2__0__Impl8940); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4255:1: rule__EnumeratorType__Group_2__1 : rule__EnumeratorType__Group_2__1__Impl rule__EnumeratorType__Group_2__2 ;
    public final void rule__EnumeratorType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4259:1: ( rule__EnumeratorType__Group_2__1__Impl rule__EnumeratorType__Group_2__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4260:2: rule__EnumeratorType__Group_2__1__Impl rule__EnumeratorType__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__1__Impl_in_rule__EnumeratorType__Group_2__18971);
            rule__EnumeratorType__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__2_in_rule__EnumeratorType__Group_2__18974);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4267:1: rule__EnumeratorType__Group_2__1__Impl : ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* ) ;
    public final void rule__EnumeratorType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4271:1: ( ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4272:1: ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4272:1: ( ( rule__EnumeratorType__ParametersAssignment_2_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4273:1: ( rule__EnumeratorType__ParametersAssignment_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getParametersAssignment_2_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4274:1: ( rule__EnumeratorType__ParametersAssignment_2_1 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( ((LA45_0>=14 && LA45_0<=21)||(LA45_0>=37 && LA45_0<=51)||LA45_0==55) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4274:2: rule__EnumeratorType__ParametersAssignment_2_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__ParametersAssignment_2_1_in_rule__EnumeratorType__Group_2__1__Impl9001);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4284:1: rule__EnumeratorType__Group_2__2 : rule__EnumeratorType__Group_2__2__Impl ;
    public final void rule__EnumeratorType__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4288:1: ( rule__EnumeratorType__Group_2__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4289:2: rule__EnumeratorType__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_2__2__Impl_in_rule__EnumeratorType__Group_2__29032);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4295:1: rule__EnumeratorType__Group_2__2__Impl : ( '}' ) ;
    public final void rule__EnumeratorType__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4299:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4300:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4300:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4301:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getRightCurlyBracketKeyword_2_2()); 
            }
            match(input,61,FollowSets000.FOLLOW_61_in_rule__EnumeratorType__Group_2__2__Impl9060); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4320:1: rule__EnumeratorType__Group_3__0 : rule__EnumeratorType__Group_3__0__Impl rule__EnumeratorType__Group_3__1 ;
    public final void rule__EnumeratorType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4324:1: ( rule__EnumeratorType__Group_3__0__Impl rule__EnumeratorType__Group_3__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4325:2: rule__EnumeratorType__Group_3__0__Impl rule__EnumeratorType__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__0__Impl_in_rule__EnumeratorType__Group_3__09097);
            rule__EnumeratorType__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__1_in_rule__EnumeratorType__Group_3__09100);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4332:1: rule__EnumeratorType__Group_3__0__Impl : ( ':' ) ;
    public final void rule__EnumeratorType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4336:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4337:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4337:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4338:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getColonKeyword_3_0()); 
            }
            match(input,62,FollowSets000.FOLLOW_62_in_rule__EnumeratorType__Group_3__0__Impl9128); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4351:1: rule__EnumeratorType__Group_3__1 : rule__EnumeratorType__Group_3__1__Impl ;
    public final void rule__EnumeratorType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4355:1: ( rule__EnumeratorType__Group_3__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4356:2: rule__EnumeratorType__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__Group_3__1__Impl_in_rule__EnumeratorType__Group_3__19159);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4362:1: rule__EnumeratorType__Group_3__1__Impl : ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) ) ;
    public final void rule__EnumeratorType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4366:1: ( ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4367:1: ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4367:1: ( ( rule__EnumeratorType__DescriptionAssignment_3_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4368:1: ( rule__EnumeratorType__DescriptionAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getDescriptionAssignment_3_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4369:1: ( rule__EnumeratorType__DescriptionAssignment_3_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4369:2: rule__EnumeratorType__DescriptionAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumeratorType__DescriptionAssignment_3_1_in_rule__EnumeratorType__Group_3__1__Impl9186);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4383:1: rule__ReferenceType__Group__0 : rule__ReferenceType__Group__0__Impl rule__ReferenceType__Group__1 ;
    public final void rule__ReferenceType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4387:1: ( rule__ReferenceType__Group__0__Impl rule__ReferenceType__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4388:2: rule__ReferenceType__Group__0__Impl rule__ReferenceType__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__0__Impl_in_rule__ReferenceType__Group__09220);
            rule__ReferenceType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__1_in_rule__ReferenceType__Group__09223);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4395:1: rule__ReferenceType__Group__0__Impl : ( () ) ;
    public final void rule__ReferenceType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4399:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4400:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4400:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4401:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getReferenceTypeAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4402:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4404:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4414:1: rule__ReferenceType__Group__1 : rule__ReferenceType__Group__1__Impl rule__ReferenceType__Group__2 ;
    public final void rule__ReferenceType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4418:1: ( rule__ReferenceType__Group__1__Impl rule__ReferenceType__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4419:2: rule__ReferenceType__Group__1__Impl rule__ReferenceType__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__1__Impl_in_rule__ReferenceType__Group__19281);
            rule__ReferenceType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__2_in_rule__ReferenceType__Group__19284);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4426:1: rule__ReferenceType__Group__1__Impl : ( ( rule__ReferenceType__TypeAssignment_1 ) ) ;
    public final void rule__ReferenceType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4430:1: ( ( ( rule__ReferenceType__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4431:1: ( ( rule__ReferenceType__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4431:1: ( ( rule__ReferenceType__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4432:1: ( rule__ReferenceType__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4433:1: ( rule__ReferenceType__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4433:2: rule__ReferenceType__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__TypeAssignment_1_in_rule__ReferenceType__Group__1__Impl9311);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4443:1: rule__ReferenceType__Group__2 : rule__ReferenceType__Group__2__Impl rule__ReferenceType__Group__3 ;
    public final void rule__ReferenceType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4447:1: ( rule__ReferenceType__Group__2__Impl rule__ReferenceType__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4448:2: rule__ReferenceType__Group__2__Impl rule__ReferenceType__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__2__Impl_in_rule__ReferenceType__Group__29341);
            rule__ReferenceType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__3_in_rule__ReferenceType__Group__29344);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4455:1: rule__ReferenceType__Group__2__Impl : ( ( rule__ReferenceType__NameAssignment_2 ) ) ;
    public final void rule__ReferenceType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4459:1: ( ( ( rule__ReferenceType__NameAssignment_2 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4460:1: ( ( rule__ReferenceType__NameAssignment_2 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4460:1: ( ( rule__ReferenceType__NameAssignment_2 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4461:1: ( rule__ReferenceType__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getNameAssignment_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4462:1: ( rule__ReferenceType__NameAssignment_2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4462:2: rule__ReferenceType__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__NameAssignment_2_in_rule__ReferenceType__Group__2__Impl9371);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4472:1: rule__ReferenceType__Group__3 : rule__ReferenceType__Group__3__Impl rule__ReferenceType__Group__4 ;
    public final void rule__ReferenceType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4476:1: ( rule__ReferenceType__Group__3__Impl rule__ReferenceType__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4477:2: rule__ReferenceType__Group__3__Impl rule__ReferenceType__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__3__Impl_in_rule__ReferenceType__Group__39401);
            rule__ReferenceType__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__4_in_rule__ReferenceType__Group__39404);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4484:1: rule__ReferenceType__Group__3__Impl : ( ( rule__ReferenceType__MultiValueAssignment_3 )? ) ;
    public final void rule__ReferenceType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4488:1: ( ( ( rule__ReferenceType__MultiValueAssignment_3 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4489:1: ( ( rule__ReferenceType__MultiValueAssignment_3 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4489:1: ( ( rule__ReferenceType__MultiValueAssignment_3 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4490:1: ( rule__ReferenceType__MultiValueAssignment_3 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getMultiValueAssignment_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4491:1: ( rule__ReferenceType__MultiValueAssignment_3 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==70) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4491:2: rule__ReferenceType__MultiValueAssignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__MultiValueAssignment_3_in_rule__ReferenceType__Group__3__Impl9431);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4501:1: rule__ReferenceType__Group__4 : rule__ReferenceType__Group__4__Impl rule__ReferenceType__Group__5 ;
    public final void rule__ReferenceType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4505:1: ( rule__ReferenceType__Group__4__Impl rule__ReferenceType__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4506:2: rule__ReferenceType__Group__4__Impl rule__ReferenceType__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__4__Impl_in_rule__ReferenceType__Group__49462);
            rule__ReferenceType__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__5_in_rule__ReferenceType__Group__49465);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4513:1: rule__ReferenceType__Group__4__Impl : ( ( rule__ReferenceType__Group_4__0 )? ) ;
    public final void rule__ReferenceType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4517:1: ( ( ( rule__ReferenceType__Group_4__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4518:1: ( ( rule__ReferenceType__Group_4__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4518:1: ( ( rule__ReferenceType__Group_4__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4519:1: ( rule__ReferenceType__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getGroup_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4520:1: ( rule__ReferenceType__Group_4__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==57) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4520:2: rule__ReferenceType__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_4__0_in_rule__ReferenceType__Group__4__Impl9492);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4530:1: rule__ReferenceType__Group__5 : rule__ReferenceType__Group__5__Impl rule__ReferenceType__Group__6 ;
    public final void rule__ReferenceType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4534:1: ( rule__ReferenceType__Group__5__Impl rule__ReferenceType__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4535:2: rule__ReferenceType__Group__5__Impl rule__ReferenceType__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__5__Impl_in_rule__ReferenceType__Group__59523);
            rule__ReferenceType__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__6_in_rule__ReferenceType__Group__59526);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4542:1: rule__ReferenceType__Group__5__Impl : ( ( rule__ReferenceType__Group_5__0 )? ) ;
    public final void rule__ReferenceType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4546:1: ( ( ( rule__ReferenceType__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4547:1: ( ( rule__ReferenceType__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4547:1: ( ( rule__ReferenceType__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4548:1: ( rule__ReferenceType__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4549:1: ( rule__ReferenceType__Group_5__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==62) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4549:2: rule__ReferenceType__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__0_in_rule__ReferenceType__Group__5__Impl9553);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4559:1: rule__ReferenceType__Group__6 : rule__ReferenceType__Group__6__Impl ;
    public final void rule__ReferenceType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4563:1: ( rule__ReferenceType__Group__6__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4564:2: rule__ReferenceType__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group__6__Impl_in_rule__ReferenceType__Group__69584);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4570:1: rule__ReferenceType__Group__6__Impl : ( ';' ) ;
    public final void rule__ReferenceType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4574:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4575:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4575:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4576:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getSemicolonKeyword_6()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__ReferenceType__Group__6__Impl9612); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4603:1: rule__ReferenceType__Group_4__0 : rule__ReferenceType__Group_4__0__Impl rule__ReferenceType__Group_4__1 ;
    public final void rule__ReferenceType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4607:1: ( rule__ReferenceType__Group_4__0__Impl rule__ReferenceType__Group_4__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4608:2: rule__ReferenceType__Group_4__0__Impl rule__ReferenceType__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_4__0__Impl_in_rule__ReferenceType__Group_4__09657);
            rule__ReferenceType__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_4__1_in_rule__ReferenceType__Group_4__09660);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4615:1: rule__ReferenceType__Group_4__0__Impl : ( '=' ) ;
    public final void rule__ReferenceType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4619:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4620:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4620:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4621:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getEqualsSignKeyword_4_0()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__ReferenceType__Group_4__0__Impl9688); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4634:1: rule__ReferenceType__Group_4__1 : rule__ReferenceType__Group_4__1__Impl ;
    public final void rule__ReferenceType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4638:1: ( rule__ReferenceType__Group_4__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4639:2: rule__ReferenceType__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_4__1__Impl_in_rule__ReferenceType__Group_4__19719);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4645:1: rule__ReferenceType__Group_4__1__Impl : ( ( rule__ReferenceType__Alternatives_4_1 ) ) ;
    public final void rule__ReferenceType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4649:1: ( ( ( rule__ReferenceType__Alternatives_4_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4650:1: ( ( rule__ReferenceType__Alternatives_4_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4650:1: ( ( rule__ReferenceType__Alternatives_4_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4651:1: ( rule__ReferenceType__Alternatives_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getAlternatives_4_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4652:1: ( rule__ReferenceType__Alternatives_4_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4652:2: rule__ReferenceType__Alternatives_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Alternatives_4_1_in_rule__ReferenceType__Group_4__1__Impl9746);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4666:1: rule__ReferenceType__Group_5__0 : rule__ReferenceType__Group_5__0__Impl rule__ReferenceType__Group_5__1 ;
    public final void rule__ReferenceType__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4670:1: ( rule__ReferenceType__Group_5__0__Impl rule__ReferenceType__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4671:2: rule__ReferenceType__Group_5__0__Impl rule__ReferenceType__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__0__Impl_in_rule__ReferenceType__Group_5__09780);
            rule__ReferenceType__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__1_in_rule__ReferenceType__Group_5__09783);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4678:1: rule__ReferenceType__Group_5__0__Impl : ( ':' ) ;
    public final void rule__ReferenceType__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4682:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4683:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4683:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4684:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getColonKeyword_5_0()); 
            }
            match(input,62,FollowSets000.FOLLOW_62_in_rule__ReferenceType__Group_5__0__Impl9811); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4697:1: rule__ReferenceType__Group_5__1 : rule__ReferenceType__Group_5__1__Impl ;
    public final void rule__ReferenceType__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4701:1: ( rule__ReferenceType__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4702:2: rule__ReferenceType__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__Group_5__1__Impl_in_rule__ReferenceType__Group_5__19842);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4708:1: rule__ReferenceType__Group_5__1__Impl : ( ( rule__ReferenceType__DescriptionAssignment_5_1 ) ) ;
    public final void rule__ReferenceType__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4712:1: ( ( ( rule__ReferenceType__DescriptionAssignment_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4713:1: ( ( rule__ReferenceType__DescriptionAssignment_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4713:1: ( ( rule__ReferenceType__DescriptionAssignment_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4714:1: ( rule__ReferenceType__DescriptionAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDescriptionAssignment_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4715:1: ( rule__ReferenceType__DescriptionAssignment_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4715:2: rule__ReferenceType__DescriptionAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReferenceType__DescriptionAssignment_5_1_in_rule__ReferenceType__Group_5__1__Impl9869);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4729:1: rule__OilObject__Group__0 : rule__OilObject__Group__0__Impl rule__OilObject__Group__1 ;
    public final void rule__OilObject__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4733:1: ( rule__OilObject__Group__0__Impl rule__OilObject__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4734:2: rule__OilObject__Group__0__Impl rule__OilObject__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__0__Impl_in_rule__OilObject__Group__09903);
            rule__OilObject__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__1_in_rule__OilObject__Group__09906);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4741:1: rule__OilObject__Group__0__Impl : ( ( rule__OilObject__TypeAssignment_0 ) ) ;
    public final void rule__OilObject__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4745:1: ( ( ( rule__OilObject__TypeAssignment_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4746:1: ( ( rule__OilObject__TypeAssignment_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4746:1: ( ( rule__OilObject__TypeAssignment_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4747:1: ( rule__OilObject__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getTypeAssignment_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4748:1: ( rule__OilObject__TypeAssignment_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4748:2: rule__OilObject__TypeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__TypeAssignment_0_in_rule__OilObject__Group__0__Impl9933);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4758:1: rule__OilObject__Group__1 : rule__OilObject__Group__1__Impl rule__OilObject__Group__2 ;
    public final void rule__OilObject__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4762:1: ( rule__OilObject__Group__1__Impl rule__OilObject__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4763:2: rule__OilObject__Group__1__Impl rule__OilObject__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__1__Impl_in_rule__OilObject__Group__19963);
            rule__OilObject__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__2_in_rule__OilObject__Group__19966);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4770:1: rule__OilObject__Group__1__Impl : ( ( rule__OilObject__NameAssignment_1 ) ) ;
    public final void rule__OilObject__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4774:1: ( ( ( rule__OilObject__NameAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4775:1: ( ( rule__OilObject__NameAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4775:1: ( ( rule__OilObject__NameAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4776:1: ( rule__OilObject__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getNameAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4777:1: ( rule__OilObject__NameAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4777:2: rule__OilObject__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__NameAssignment_1_in_rule__OilObject__Group__1__Impl9993);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4787:1: rule__OilObject__Group__2 : rule__OilObject__Group__2__Impl rule__OilObject__Group__3 ;
    public final void rule__OilObject__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4791:1: ( rule__OilObject__Group__2__Impl rule__OilObject__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4792:2: rule__OilObject__Group__2__Impl rule__OilObject__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__2__Impl_in_rule__OilObject__Group__210023);
            rule__OilObject__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__3_in_rule__OilObject__Group__210026);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4799:1: rule__OilObject__Group__2__Impl : ( ( rule__OilObject__Group_2__0 )? ) ;
    public final void rule__OilObject__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4803:1: ( ( ( rule__OilObject__Group_2__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4804:1: ( ( rule__OilObject__Group_2__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4804:1: ( ( rule__OilObject__Group_2__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4805:1: ( rule__OilObject__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getGroup_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4806:1: ( rule__OilObject__Group_2__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==60) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4806:2: rule__OilObject__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_2__0_in_rule__OilObject__Group__2__Impl10053);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4816:1: rule__OilObject__Group__3 : rule__OilObject__Group__3__Impl rule__OilObject__Group__4 ;
    public final void rule__OilObject__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4820:1: ( rule__OilObject__Group__3__Impl rule__OilObject__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4821:2: rule__OilObject__Group__3__Impl rule__OilObject__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__3__Impl_in_rule__OilObject__Group__310084);
            rule__OilObject__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__4_in_rule__OilObject__Group__310087);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4828:1: rule__OilObject__Group__3__Impl : ( ( rule__OilObject__Group_3__0 )? ) ;
    public final void rule__OilObject__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4832:1: ( ( ( rule__OilObject__Group_3__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4833:1: ( ( rule__OilObject__Group_3__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4833:1: ( ( rule__OilObject__Group_3__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4834:1: ( rule__OilObject__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getGroup_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4835:1: ( rule__OilObject__Group_3__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==62) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4835:2: rule__OilObject__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_3__0_in_rule__OilObject__Group__3__Impl10114);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4845:1: rule__OilObject__Group__4 : rule__OilObject__Group__4__Impl ;
    public final void rule__OilObject__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4849:1: ( rule__OilObject__Group__4__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4850:2: rule__OilObject__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group__4__Impl_in_rule__OilObject__Group__410145);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4856:1: rule__OilObject__Group__4__Impl : ( ';' ) ;
    public final void rule__OilObject__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4860:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4861:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4861:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4862:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getSemicolonKeyword_4()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__OilObject__Group__4__Impl10173); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4885:1: rule__OilObject__Group_2__0 : rule__OilObject__Group_2__0__Impl rule__OilObject__Group_2__1 ;
    public final void rule__OilObject__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4889:1: ( rule__OilObject__Group_2__0__Impl rule__OilObject__Group_2__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4890:2: rule__OilObject__Group_2__0__Impl rule__OilObject__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_2__0__Impl_in_rule__OilObject__Group_2__010214);
            rule__OilObject__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_2__1_in_rule__OilObject__Group_2__010217);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4897:1: rule__OilObject__Group_2__0__Impl : ( '{' ) ;
    public final void rule__OilObject__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4901:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4902:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4902:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4903:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getLeftCurlyBracketKeyword_2_0()); 
            }
            match(input,60,FollowSets000.FOLLOW_60_in_rule__OilObject__Group_2__0__Impl10245); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4916:1: rule__OilObject__Group_2__1 : rule__OilObject__Group_2__1__Impl rule__OilObject__Group_2__2 ;
    public final void rule__OilObject__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4920:1: ( rule__OilObject__Group_2__1__Impl rule__OilObject__Group_2__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4921:2: rule__OilObject__Group_2__1__Impl rule__OilObject__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_2__1__Impl_in_rule__OilObject__Group_2__110276);
            rule__OilObject__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_2__2_in_rule__OilObject__Group_2__110279);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4928:1: rule__OilObject__Group_2__1__Impl : ( ( rule__OilObject__ParametersAssignment_2_1 )* ) ;
    public final void rule__OilObject__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4932:1: ( ( ( rule__OilObject__ParametersAssignment_2_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4933:1: ( ( rule__OilObject__ParametersAssignment_2_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4933:1: ( ( rule__OilObject__ParametersAssignment_2_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4934:1: ( rule__OilObject__ParametersAssignment_2_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getParametersAssignment_2_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4935:1: ( rule__OilObject__ParametersAssignment_2_1 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_ID||(LA51_0>=14 && LA51_0<=51)) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4935:2: rule__OilObject__ParametersAssignment_2_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OilObject__ParametersAssignment_2_1_in_rule__OilObject__Group_2__1__Impl10306);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4945:1: rule__OilObject__Group_2__2 : rule__OilObject__Group_2__2__Impl ;
    public final void rule__OilObject__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4949:1: ( rule__OilObject__Group_2__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4950:2: rule__OilObject__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_2__2__Impl_in_rule__OilObject__Group_2__210337);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4956:1: rule__OilObject__Group_2__2__Impl : ( '}' ) ;
    public final void rule__OilObject__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4960:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4961:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4961:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4962:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getRightCurlyBracketKeyword_2_2()); 
            }
            match(input,61,FollowSets000.FOLLOW_61_in_rule__OilObject__Group_2__2__Impl10365); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4981:1: rule__OilObject__Group_3__0 : rule__OilObject__Group_3__0__Impl rule__OilObject__Group_3__1 ;
    public final void rule__OilObject__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4985:1: ( rule__OilObject__Group_3__0__Impl rule__OilObject__Group_3__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4986:2: rule__OilObject__Group_3__0__Impl rule__OilObject__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_3__0__Impl_in_rule__OilObject__Group_3__010402);
            rule__OilObject__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_3__1_in_rule__OilObject__Group_3__010405);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4993:1: rule__OilObject__Group_3__0__Impl : ( ':' ) ;
    public final void rule__OilObject__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4997:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4998:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4998:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:4999:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getColonKeyword_3_0()); 
            }
            match(input,62,FollowSets000.FOLLOW_62_in_rule__OilObject__Group_3__0__Impl10433); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5012:1: rule__OilObject__Group_3__1 : rule__OilObject__Group_3__1__Impl ;
    public final void rule__OilObject__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5016:1: ( rule__OilObject__Group_3__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5017:2: rule__OilObject__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__Group_3__1__Impl_in_rule__OilObject__Group_3__110464);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5023:1: rule__OilObject__Group_3__1__Impl : ( ( rule__OilObject__DescriptionAssignment_3_1 ) ) ;
    public final void rule__OilObject__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5027:1: ( ( ( rule__OilObject__DescriptionAssignment_3_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5028:1: ( ( rule__OilObject__DescriptionAssignment_3_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5028:1: ( ( rule__OilObject__DescriptionAssignment_3_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5029:1: ( rule__OilObject__DescriptionAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getDescriptionAssignment_3_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5030:1: ( rule__OilObject__DescriptionAssignment_3_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5030:2: rule__OilObject__DescriptionAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OilObject__DescriptionAssignment_3_1_in_rule__OilObject__Group_3__1__Impl10491);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5044:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5048:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5049:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__010525);
            rule__Parameter__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__010528);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5056:1: rule__Parameter__Group__0__Impl : ( () ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5060:1: ( ( () ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5061:1: ( () )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5061:1: ( () )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5062:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getParameterAction_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5063:1: ()
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5065:1: 
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5075:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5079:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5080:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__110586);
            rule__Parameter__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__110589);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5087:1: rule__Parameter__Group__1__Impl : ( ( rule__Parameter__TypeAssignment_1 ) ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5091:1: ( ( ( rule__Parameter__TypeAssignment_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5092:1: ( ( rule__Parameter__TypeAssignment_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5092:1: ( ( rule__Parameter__TypeAssignment_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5093:1: ( rule__Parameter__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeAssignment_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5094:1: ( rule__Parameter__TypeAssignment_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5094:2: rule__Parameter__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__TypeAssignment_1_in_rule__Parameter__Group__1__Impl10616);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5104:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl rule__Parameter__Group__3 ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5108:1: ( rule__Parameter__Group__2__Impl rule__Parameter__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5109:2: rule__Parameter__Group__2__Impl rule__Parameter__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__210646);
            rule__Parameter__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__3_in_rule__Parameter__Group__210649);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5116:1: rule__Parameter__Group__2__Impl : ( '=' ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5120:1: ( ( '=' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5121:1: ( '=' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5121:1: ( '=' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5122:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getEqualsSignKeyword_2()); 
            }
            match(input,57,FollowSets000.FOLLOW_57_in_rule__Parameter__Group__2__Impl10677); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5135:1: rule__Parameter__Group__3 : rule__Parameter__Group__3__Impl rule__Parameter__Group__4 ;
    public final void rule__Parameter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5139:1: ( rule__Parameter__Group__3__Impl rule__Parameter__Group__4 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5140:2: rule__Parameter__Group__3__Impl rule__Parameter__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__3__Impl_in_rule__Parameter__Group__310708);
            rule__Parameter__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__4_in_rule__Parameter__Group__310711);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5147:1: rule__Parameter__Group__3__Impl : ( ( rule__Parameter__Alternatives_3 ) ) ;
    public final void rule__Parameter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5151:1: ( ( ( rule__Parameter__Alternatives_3 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5152:1: ( ( rule__Parameter__Alternatives_3 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5152:1: ( ( rule__Parameter__Alternatives_3 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5153:1: ( rule__Parameter__Alternatives_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getAlternatives_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5154:1: ( rule__Parameter__Alternatives_3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5154:2: rule__Parameter__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Alternatives_3_in_rule__Parameter__Group__3__Impl10738);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5164:1: rule__Parameter__Group__4 : rule__Parameter__Group__4__Impl rule__Parameter__Group__5 ;
    public final void rule__Parameter__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5168:1: ( rule__Parameter__Group__4__Impl rule__Parameter__Group__5 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5169:2: rule__Parameter__Group__4__Impl rule__Parameter__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__4__Impl_in_rule__Parameter__Group__410768);
            rule__Parameter__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__5_in_rule__Parameter__Group__410771);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5176:1: rule__Parameter__Group__4__Impl : ( ( rule__Parameter__Group_4__0 )? ) ;
    public final void rule__Parameter__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5180:1: ( ( ( rule__Parameter__Group_4__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5181:1: ( ( rule__Parameter__Group_4__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5181:1: ( ( rule__Parameter__Group_4__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5182:1: ( rule__Parameter__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getGroup_4()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5183:1: ( rule__Parameter__Group_4__0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==60) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5183:2: rule__Parameter__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__0_in_rule__Parameter__Group__4__Impl10798);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5193:1: rule__Parameter__Group__5 : rule__Parameter__Group__5__Impl rule__Parameter__Group__6 ;
    public final void rule__Parameter__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5197:1: ( rule__Parameter__Group__5__Impl rule__Parameter__Group__6 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5198:2: rule__Parameter__Group__5__Impl rule__Parameter__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__5__Impl_in_rule__Parameter__Group__510829);
            rule__Parameter__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__6_in_rule__Parameter__Group__510832);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5205:1: rule__Parameter__Group__5__Impl : ( ( rule__Parameter__Group_5__0 )? ) ;
    public final void rule__Parameter__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5209:1: ( ( ( rule__Parameter__Group_5__0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5210:1: ( ( rule__Parameter__Group_5__0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5210:1: ( ( rule__Parameter__Group_5__0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5211:1: ( rule__Parameter__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getGroup_5()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5212:1: ( rule__Parameter__Group_5__0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==62) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5212:2: rule__Parameter__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__0_in_rule__Parameter__Group__5__Impl10859);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5222:1: rule__Parameter__Group__6 : rule__Parameter__Group__6__Impl ;
    public final void rule__Parameter__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5226:1: ( rule__Parameter__Group__6__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5227:2: rule__Parameter__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__6__Impl_in_rule__Parameter__Group__610890);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5233:1: rule__Parameter__Group__6__Impl : ( ';' ) ;
    public final void rule__Parameter__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5237:1: ( ( ';' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5238:1: ( ';' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5238:1: ( ';' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5239:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getSemicolonKeyword_6()); 
            }
            match(input,58,FollowSets000.FOLLOW_58_in_rule__Parameter__Group__6__Impl10918); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5266:1: rule__Parameter__Group_4__0 : rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 ;
    public final void rule__Parameter__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5270:1: ( rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5271:2: rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__0__Impl_in_rule__Parameter__Group_4__010963);
            rule__Parameter__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__1_in_rule__Parameter__Group_4__010966);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5278:1: rule__Parameter__Group_4__0__Impl : ( '{' ) ;
    public final void rule__Parameter__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5282:1: ( ( '{' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5283:1: ( '{' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5283:1: ( '{' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5284:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getLeftCurlyBracketKeyword_4_0()); 
            }
            match(input,60,FollowSets000.FOLLOW_60_in_rule__Parameter__Group_4__0__Impl10994); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5297:1: rule__Parameter__Group_4__1 : rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2 ;
    public final void rule__Parameter__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5301:1: ( rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5302:2: rule__Parameter__Group_4__1__Impl rule__Parameter__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__1__Impl_in_rule__Parameter__Group_4__111025);
            rule__Parameter__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__2_in_rule__Parameter__Group_4__111028);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5309:1: rule__Parameter__Group_4__1__Impl : ( ( rule__Parameter__ParametersAssignment_4_1 )* ) ;
    public final void rule__Parameter__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5313:1: ( ( ( rule__Parameter__ParametersAssignment_4_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5314:1: ( ( rule__Parameter__ParametersAssignment_4_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5314:1: ( ( rule__Parameter__ParametersAssignment_4_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5315:1: ( rule__Parameter__ParametersAssignment_4_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getParametersAssignment_4_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5316:1: ( rule__Parameter__ParametersAssignment_4_1 )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_ID||(LA54_0>=14 && LA54_0<=51)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5316:2: rule__Parameter__ParametersAssignment_4_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Parameter__ParametersAssignment_4_1_in_rule__Parameter__Group_4__1__Impl11055);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5326:1: rule__Parameter__Group_4__2 : rule__Parameter__Group_4__2__Impl ;
    public final void rule__Parameter__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5330:1: ( rule__Parameter__Group_4__2__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5331:2: rule__Parameter__Group_4__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_4__2__Impl_in_rule__Parameter__Group_4__211086);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5337:1: rule__Parameter__Group_4__2__Impl : ( '}' ) ;
    public final void rule__Parameter__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5341:1: ( ( '}' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5342:1: ( '}' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5342:1: ( '}' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5343:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getRightCurlyBracketKeyword_4_2()); 
            }
            match(input,61,FollowSets000.FOLLOW_61_in_rule__Parameter__Group_4__2__Impl11114); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5362:1: rule__Parameter__Group_5__0 : rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 ;
    public final void rule__Parameter__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5366:1: ( rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5367:2: rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__0__Impl_in_rule__Parameter__Group_5__011151);
            rule__Parameter__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__1_in_rule__Parameter__Group_5__011154);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5374:1: rule__Parameter__Group_5__0__Impl : ( ':' ) ;
    public final void rule__Parameter__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5378:1: ( ( ':' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5379:1: ( ':' )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5379:1: ( ':' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5380:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getColonKeyword_5_0()); 
            }
            match(input,62,FollowSets000.FOLLOW_62_in_rule__Parameter__Group_5__0__Impl11182); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5393:1: rule__Parameter__Group_5__1 : rule__Parameter__Group_5__1__Impl ;
    public final void rule__Parameter__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5397:1: ( rule__Parameter__Group_5__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5398:2: rule__Parameter__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group_5__1__Impl_in_rule__Parameter__Group_5__111213);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5404:1: rule__Parameter__Group_5__1__Impl : ( ( rule__Parameter__DescriptionAssignment_5_1 ) ) ;
    public final void rule__Parameter__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5408:1: ( ( ( rule__Parameter__DescriptionAssignment_5_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5409:1: ( ( rule__Parameter__DescriptionAssignment_5_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5409:1: ( ( rule__Parameter__DescriptionAssignment_5_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5410:1: ( rule__Parameter__DescriptionAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getDescriptionAssignment_5_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5411:1: ( rule__Parameter__DescriptionAssignment_5_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5411:2: rule__Parameter__DescriptionAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__DescriptionAssignment_5_1_in_rule__Parameter__Group_5__1__Impl11240);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5425:1: rule__INT__Group__0 : rule__INT__Group__0__Impl rule__INT__Group__1 ;
    public final void rule__INT__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5429:1: ( rule__INT__Group__0__Impl rule__INT__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5430:2: rule__INT__Group__0__Impl rule__INT__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group__0__Impl_in_rule__INT__Group__011274);
            rule__INT__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group__1_in_rule__INT__Group__011277);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5437:1: rule__INT__Group__0__Impl : ( ( rule__INT__Alternatives_0 )? ) ;
    public final void rule__INT__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5441:1: ( ( ( rule__INT__Alternatives_0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5442:1: ( ( rule__INT__Alternatives_0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5442:1: ( ( rule__INT__Alternatives_0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5443:1: ( rule__INT__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getAlternatives_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5444:1: ( rule__INT__Alternatives_0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=52 && LA55_0<=53)) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5444:2: rule__INT__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__INT__Alternatives_0_in_rule__INT__Group__0__Impl11304);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5454:1: rule__INT__Group__1 : rule__INT__Group__1__Impl ;
    public final void rule__INT__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5458:1: ( rule__INT__Group__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5459:2: rule__INT__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group__1__Impl_in_rule__INT__Group__111335);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5465:1: rule__INT__Group__1__Impl : ( ( rule__INT__Alternatives_1 ) ) ;
    public final void rule__INT__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5469:1: ( ( ( rule__INT__Alternatives_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5470:1: ( ( rule__INT__Alternatives_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5470:1: ( ( rule__INT__Alternatives_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5471:1: ( rule__INT__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getAlternatives_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5472:1: ( rule__INT__Alternatives_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5472:2: rule__INT__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Alternatives_1_in_rule__INT__Group__1__Impl11362);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5486:1: rule__INT__Group_1_0__0 : rule__INT__Group_1_0__0__Impl rule__INT__Group_1_0__1 ;
    public final void rule__INT__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5490:1: ( rule__INT__Group_1_0__0__Impl rule__INT__Group_1_0__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5491:2: rule__INT__Group_1_0__0__Impl rule__INT__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__0__Impl_in_rule__INT__Group_1_0__011396);
            rule__INT__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__1_in_rule__INT__Group_1_0__011399);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5498:1: rule__INT__Group_1_0__0__Impl : ( RULE_NON_ZERO_INT ) ;
    public final void rule__INT__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5502:1: ( ( RULE_NON_ZERO_INT ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5503:1: ( RULE_NON_ZERO_INT )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5503:1: ( RULE_NON_ZERO_INT )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5504:1: RULE_NON_ZERO_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getNON_ZERO_INTTerminalRuleCall_1_0_0()); 
            }
            match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Group_1_0__0__Impl11426); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5515:1: rule__INT__Group_1_0__1 : rule__INT__Group_1_0__1__Impl ;
    public final void rule__INT__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5519:1: ( rule__INT__Group_1_0__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5520:2: rule__INT__Group_1_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__INT__Group_1_0__1__Impl_in_rule__INT__Group_1_0__111455);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5526:1: rule__INT__Group_1_0__1__Impl : ( ( rule__INT__Alternatives_1_0_1 )* ) ;
    public final void rule__INT__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5530:1: ( ( ( rule__INT__Alternatives_1_0_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5531:1: ( ( rule__INT__Alternatives_1_0_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5531:1: ( ( rule__INT__Alternatives_1_0_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5532:1: ( rule__INT__Alternatives_1_0_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getINTAccess().getAlternatives_1_0_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5533:1: ( rule__INT__Alternatives_1_0_1 )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==RULE_ZERO_INT||LA56_0==RULE_NON_ZERO_INT) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5533:2: rule__INT__Alternatives_1_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__INT__Alternatives_1_0_1_in_rule__INT__Group_1_0__1__Impl11482);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5547:1: rule__FLOAT__Group__0 : rule__FLOAT__Group__0__Impl rule__FLOAT__Group__1 ;
    public final void rule__FLOAT__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5551:1: ( rule__FLOAT__Group__0__Impl rule__FLOAT__Group__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5552:2: rule__FLOAT__Group__0__Impl rule__FLOAT__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group__0__Impl_in_rule__FLOAT__Group__011517);
            rule__FLOAT__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group__1_in_rule__FLOAT__Group__011520);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5559:1: rule__FLOAT__Group__0__Impl : ( ( rule__FLOAT__Alternatives_0 )? ) ;
    public final void rule__FLOAT__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5563:1: ( ( ( rule__FLOAT__Alternatives_0 )? ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5564:1: ( ( rule__FLOAT__Alternatives_0 )? )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5564:1: ( ( rule__FLOAT__Alternatives_0 )? )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5565:1: ( rule__FLOAT__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFLOATAccess().getAlternatives_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5566:1: ( rule__FLOAT__Alternatives_0 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( ((LA57_0>=52 && LA57_0<=53)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5566:2: rule__FLOAT__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Alternatives_0_in_rule__FLOAT__Group__0__Impl11547);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5576:1: rule__FLOAT__Group__1 : rule__FLOAT__Group__1__Impl rule__FLOAT__Group__2 ;
    public final void rule__FLOAT__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5580:1: ( rule__FLOAT__Group__1__Impl rule__FLOAT__Group__2 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5581:2: rule__FLOAT__Group__1__Impl rule__FLOAT__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group__1__Impl_in_rule__FLOAT__Group__111578);
            rule__FLOAT__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group__2_in_rule__FLOAT__Group__111581);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5588:1: rule__FLOAT__Group__1__Impl : ( ( rule__FLOAT__Alternatives_1 ) ) ;
    public final void rule__FLOAT__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5592:1: ( ( ( rule__FLOAT__Alternatives_1 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5593:1: ( ( rule__FLOAT__Alternatives_1 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5593:1: ( ( rule__FLOAT__Alternatives_1 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5594:1: ( rule__FLOAT__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFLOATAccess().getAlternatives_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5595:1: ( rule__FLOAT__Alternatives_1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5595:2: rule__FLOAT__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Alternatives_1_in_rule__FLOAT__Group__1__Impl11608);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5605:1: rule__FLOAT__Group__2 : rule__FLOAT__Group__2__Impl rule__FLOAT__Group__3 ;
    public final void rule__FLOAT__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5609:1: ( rule__FLOAT__Group__2__Impl rule__FLOAT__Group__3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5610:2: rule__FLOAT__Group__2__Impl rule__FLOAT__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group__2__Impl_in_rule__FLOAT__Group__211638);
            rule__FLOAT__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group__3_in_rule__FLOAT__Group__211641);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5617:1: rule__FLOAT__Group__2__Impl : ( ( '.' ) ) ;
    public final void rule__FLOAT__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5621:1: ( ( ( '.' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5622:1: ( ( '.' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5622:1: ( ( '.' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5623:1: ( '.' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFLOATAccess().getFullStopKeyword_2()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5624:1: ( '.' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5625:2: '.'
            {
            match(input,68,FollowSets000.FOLLOW_68_in_rule__FLOAT__Group__2__Impl11670); if (state.failed) return ;

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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5636:1: rule__FLOAT__Group__3 : rule__FLOAT__Group__3__Impl ;
    public final void rule__FLOAT__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5640:1: ( rule__FLOAT__Group__3__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5641:2: rule__FLOAT__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group__3__Impl_in_rule__FLOAT__Group__311702);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5647:1: rule__FLOAT__Group__3__Impl : ( ( ( rule__FLOAT__Alternatives_3 ) ) ( ( rule__FLOAT__Alternatives_3 )* ) ) ;
    public final void rule__FLOAT__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5651:1: ( ( ( ( rule__FLOAT__Alternatives_3 ) ) ( ( rule__FLOAT__Alternatives_3 )* ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5652:1: ( ( ( rule__FLOAT__Alternatives_3 ) ) ( ( rule__FLOAT__Alternatives_3 )* ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5652:1: ( ( ( rule__FLOAT__Alternatives_3 ) ) ( ( rule__FLOAT__Alternatives_3 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5653:1: ( ( rule__FLOAT__Alternatives_3 ) ) ( ( rule__FLOAT__Alternatives_3 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5653:1: ( ( rule__FLOAT__Alternatives_3 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5654:1: ( rule__FLOAT__Alternatives_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFLOATAccess().getAlternatives_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5655:1: ( rule__FLOAT__Alternatives_3 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5655:2: rule__FLOAT__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Alternatives_3_in_rule__FLOAT__Group__3__Impl11731);
            rule__FLOAT__Alternatives_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFLOATAccess().getAlternatives_3()); 
            }

            }

            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5658:1: ( ( rule__FLOAT__Alternatives_3 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5659:1: ( rule__FLOAT__Alternatives_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFLOATAccess().getAlternatives_3()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5660:1: ( rule__FLOAT__Alternatives_3 )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==RULE_ZERO_INT||LA58_0==RULE_NON_ZERO_INT) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5660:2: rule__FLOAT__Alternatives_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Alternatives_3_in_rule__FLOAT__Group__3__Impl11743);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5679:1: rule__FLOAT__Group_1_1__0 : rule__FLOAT__Group_1_1__0__Impl rule__FLOAT__Group_1_1__1 ;
    public final void rule__FLOAT__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5683:1: ( rule__FLOAT__Group_1_1__0__Impl rule__FLOAT__Group_1_1__1 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5684:2: rule__FLOAT__Group_1_1__0__Impl rule__FLOAT__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group_1_1__0__Impl_in_rule__FLOAT__Group_1_1__011784);
            rule__FLOAT__Group_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group_1_1__1_in_rule__FLOAT__Group_1_1__011787);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5691:1: rule__FLOAT__Group_1_1__0__Impl : ( RULE_NON_ZERO_INT ) ;
    public final void rule__FLOAT__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5695:1: ( ( RULE_NON_ZERO_INT ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5696:1: ( RULE_NON_ZERO_INT )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5696:1: ( RULE_NON_ZERO_INT )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5697:1: RULE_NON_ZERO_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFLOATAccess().getNON_ZERO_INTTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_NON_ZERO_INT,FollowSets000.FOLLOW_RULE_NON_ZERO_INT_in_rule__FLOAT__Group_1_1__0__Impl11814); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5708:1: rule__FLOAT__Group_1_1__1 : rule__FLOAT__Group_1_1__1__Impl ;
    public final void rule__FLOAT__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5712:1: ( rule__FLOAT__Group_1_1__1__Impl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5713:2: rule__FLOAT__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Group_1_1__1__Impl_in_rule__FLOAT__Group_1_1__111843);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5719:1: rule__FLOAT__Group_1_1__1__Impl : ( ( rule__FLOAT__Alternatives_1_1_1 )* ) ;
    public final void rule__FLOAT__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5723:1: ( ( ( rule__FLOAT__Alternatives_1_1_1 )* ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5724:1: ( ( rule__FLOAT__Alternatives_1_1_1 )* )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5724:1: ( ( rule__FLOAT__Alternatives_1_1_1 )* )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5725:1: ( rule__FLOAT__Alternatives_1_1_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFLOATAccess().getAlternatives_1_1_1()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5726:1: ( rule__FLOAT__Alternatives_1_1_1 )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==RULE_ZERO_INT||LA59_0==RULE_NON_ZERO_INT) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5726:2: rule__FLOAT__Alternatives_1_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__FLOAT__Alternatives_1_1_1_in_rule__FLOAT__Group_1_1__1__Impl11870);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5741:1: rule__OilFile__OilVersionAssignment_1_2 : ( RULE_STRING ) ;
    public final void rule__OilFile__OilVersionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5745:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5746:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5746:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5747:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getOilVersionSTRINGTerminalRuleCall_1_2_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilFile__OilVersionAssignment_1_211910); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5756:1: rule__OilFile__ImplementationAssignment_2 : ( ruleOilImplementation ) ;
    public final void rule__OilFile__ImplementationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5760:1: ( ( ruleOilImplementation ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5761:1: ( ruleOilImplementation )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5761:1: ( ruleOilImplementation )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5762:1: ruleOilImplementation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getImplementationOilImplementationParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilImplementation_in_rule__OilFile__ImplementationAssignment_211941);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5771:1: rule__OilFile__ApplicationAssignment_3 : ( ruleOilApplication ) ;
    public final void rule__OilFile__ApplicationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5775:1: ( ( ruleOilApplication ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5776:1: ( ruleOilApplication )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5776:1: ( ruleOilApplication )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5777:1: ruleOilApplication
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilFileAccess().getApplicationOilApplicationParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilApplication_in_rule__OilFile__ApplicationAssignment_311972);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5786:1: rule__OilImplementation__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OilImplementation__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5790:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5791:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5791:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5792:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__OilImplementation__NameAssignment_112003); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5801:1: rule__OilImplementation__OilObjectsAssignment_3 : ( ruleOilObjectImpl ) ;
    public final void rule__OilImplementation__OilObjectsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5805:1: ( ( ruleOilObjectImpl ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5806:1: ( ruleOilObjectImpl )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5806:1: ( ruleOilObjectImpl )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5807:1: ruleOilObjectImpl
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilImplementationAccess().getOilObjectsOilObjectImplParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObjectImpl_in_rule__OilImplementation__OilObjectsAssignment_312034);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5816:1: rule__OilObjectImpl__TypeAssignment_0 : ( ruleObjectType ) ;
    public final void rule__OilObjectImpl__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5820:1: ( ( ruleObjectType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5821:1: ( ruleObjectType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5821:1: ( ruleObjectType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5822:1: ruleObjectType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectType_in_rule__OilObjectImpl__TypeAssignment_012065);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5831:1: rule__OilObjectImpl__ParametersAssignment_2 : ( ruleParameterType ) ;
    public final void rule__OilObjectImpl__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5835:1: ( ( ruleParameterType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5836:1: ( ruleParameterType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5836:1: ( ruleParameterType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5837:1: ruleParameterType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getParametersParameterTypeParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_rule__OilObjectImpl__ParametersAssignment_212096);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5846:1: rule__OilObjectImpl__DescriptionAssignment_4_1 : ( RULE_STRING ) ;
    public final void rule__OilObjectImpl__DescriptionAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5850:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5851:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5851:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5852:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectImplAccess().getDescriptionSTRINGTerminalRuleCall_4_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilObjectImpl__DescriptionAssignment_4_112127); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5861:1: rule__OilApplication__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OilApplication__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5865:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5866:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5866:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5867:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__OilApplication__NameAssignment_112158); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5876:1: rule__OilApplication__OilObjectsAssignment_3 : ( ruleOilObject ) ;
    public final void rule__OilApplication__OilObjectsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5880:1: ( ( ruleOilObject ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5881:1: ( ruleOilObject )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5881:1: ( ruleOilObject )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5882:1: ruleOilObject
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getOilObjectsOilObjectParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOilObject_in_rule__OilApplication__OilObjectsAssignment_312189);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5891:1: rule__OilApplication__DescriptionAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__OilApplication__DescriptionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5895:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5896:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5896:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5897:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilApplicationAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilApplication__DescriptionAssignment_5_112220); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5906:1: rule__ValueList__ValuesAssignment_1 : ( ruleGenericNumber ) ;
    public final void rule__ValueList__ValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5910:1: ( ( ruleGenericNumber ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5911:1: ( ruleGenericNumber )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5911:1: ( ruleGenericNumber )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5912:1: ruleGenericNumber
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueListAccess().getValuesGenericNumberParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericNumber_in_rule__ValueList__ValuesAssignment_112251);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5921:1: rule__ValueList__ValuesAssignment_2_1 : ( ruleGenericNumber ) ;
    public final void rule__ValueList__ValuesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5925:1: ( ( ruleGenericNumber ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5926:1: ( ruleGenericNumber )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5926:1: ( ruleGenericNumber )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5927:1: ruleGenericNumber
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueListAccess().getValuesGenericNumberParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericNumber_in_rule__ValueList__ValuesAssignment_2_112282);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5936:1: rule__Range__MinAssignment_1 : ( ruleGenericNumber ) ;
    public final void rule__Range__MinAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5940:1: ( ( ruleGenericNumber ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5941:1: ( ruleGenericNumber )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5941:1: ( ruleGenericNumber )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5942:1: ruleGenericNumber
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getMinGenericNumberParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericNumber_in_rule__Range__MinAssignment_112313);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5951:1: rule__Range__MaxAssignment_3 : ( ruleGenericNumber ) ;
    public final void rule__Range__MaxAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5955:1: ( ( ruleGenericNumber ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5956:1: ( ruleGenericNumber )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5956:1: ( ruleGenericNumber )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5957:1: ruleGenericNumber
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRangeAccess().getMaxGenericNumberParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericNumber_in_rule__Range__MaxAssignment_312344);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5966:1: rule__ValueType__TypeAssignment_1 : ( ruleVType ) ;
    public final void rule__ValueType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5970:1: ( ( ruleVType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5971:1: ( ruleVType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5971:1: ( ruleVType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5972:1: ruleVType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getTypeVTypeEnumRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVType_in_rule__ValueType__TypeAssignment_112375);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5981:1: rule__ValueType__WithAutoAssignment_2 : ( ( 'WITH_AUTO' ) ) ;
    public final void rule__ValueType__WithAutoAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5985:1: ( ( ( 'WITH_AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5986:1: ( ( 'WITH_AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5986:1: ( ( 'WITH_AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5987:1: ( 'WITH_AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5988:1: ( 'WITH_AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:5989:1: 'WITH_AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            match(input,69,FollowSets000.FOLLOW_69_in_rule__ValueType__WithAutoAssignment_212411); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6004:1: rule__ValueType__ValidValuesAssignment_3_1 : ( ruleValidValues ) ;
    public final void rule__ValueType__ValidValuesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6008:1: ( ( ruleValidValues ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6009:1: ( ruleValidValues )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6009:1: ( ruleValidValues )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6010:1: ruleValidValues
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getValidValuesValidValuesParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleValidValues_in_rule__ValueType__ValidValuesAssignment_3_112450);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6019:1: rule__ValueType__NameAssignment_4 : ( ruleSpecialId ) ;
    public final void rule__ValueType__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6023:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6024:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6024:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6025:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getNameSpecialIdParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__ValueType__NameAssignment_412481);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6034:1: rule__ValueType__MultiValueAssignment_5 : ( ( '[]' ) ) ;
    public final void rule__ValueType__MultiValueAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6038:1: ( ( ( '[]' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6039:1: ( ( '[]' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6039:1: ( ( '[]' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6040:1: ( '[]' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6041:1: ( '[]' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6042:1: '[]'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0()); 
            }
            match(input,70,FollowSets000.FOLLOW_70_in_rule__ValueType__MultiValueAssignment_512517); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6057:1: rule__ValueType__DefaultAutoAssignment_6_1_0 : ( ( 'AUTO' ) ) ;
    public final void rule__ValueType__DefaultAutoAssignment_6_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6061:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6062:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6062:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6063:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6064:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6065:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }
            match(input,71,FollowSets000.FOLLOW_71_in_rule__ValueType__DefaultAutoAssignment_6_1_012561); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6080:1: rule__ValueType__DefaultValueAssignment_6_1_1 : ( ( rule__ValueType__DefaultValueAlternatives_6_1_1_0 ) ) ;
    public final void rule__ValueType__DefaultValueAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6084:1: ( ( ( rule__ValueType__DefaultValueAlternatives_6_1_1_0 ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6085:1: ( ( rule__ValueType__DefaultValueAlternatives_6_1_1_0 ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6085:1: ( ( rule__ValueType__DefaultValueAlternatives_6_1_1_0 ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6086:1: ( rule__ValueType__DefaultValueAlternatives_6_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDefaultValueAlternatives_6_1_1_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6087:1: ( rule__ValueType__DefaultValueAlternatives_6_1_1_0 )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6087:2: rule__ValueType__DefaultValueAlternatives_6_1_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ValueType__DefaultValueAlternatives_6_1_1_0_in_rule__ValueType__DefaultValueAssignment_6_1_112600);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6096:1: rule__ValueType__DescriptionAssignment_7_1 : ( RULE_STRING ) ;
    public final void rule__ValueType__DescriptionAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6100:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6101:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6101:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6102:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getDescriptionSTRINGTerminalRuleCall_7_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ValueType__DescriptionAssignment_7_112633); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6111:1: rule__VariantType__TypeAssignment_1 : ( ruleEType ) ;
    public final void rule__VariantType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6115:1: ( ( ruleEType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6116:1: ( ruleEType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6116:1: ( ruleEType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6117:1: ruleEType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getTypeETypeEnumRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEType_in_rule__VariantType__TypeAssignment_112664);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6126:1: rule__VariantType__WithAutoAssignment_2 : ( ( 'WITH_AUTO' ) ) ;
    public final void rule__VariantType__WithAutoAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6130:1: ( ( ( 'WITH_AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6131:1: ( ( 'WITH_AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6131:1: ( ( 'WITH_AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6132:1: ( 'WITH_AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6133:1: ( 'WITH_AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6134:1: 'WITH_AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getWithAutoWITH_AUTOKeyword_2_0()); 
            }
            match(input,69,FollowSets000.FOLLOW_69_in_rule__VariantType__WithAutoAssignment_212700); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6149:1: rule__VariantType__ValuesAssignment_3_1_0 : ( ruleEnumeratorType ) ;
    public final void rule__VariantType__ValuesAssignment_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6153:1: ( ( ruleEnumeratorType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6154:1: ( ruleEnumeratorType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6154:1: ( ruleEnumeratorType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6155:1: ruleEnumeratorType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_3_1_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_3_1_012739);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6164:1: rule__VariantType__ValuesAssignment_3_1_1_1 : ( ruleEnumeratorType ) ;
    public final void rule__VariantType__ValuesAssignment_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6168:1: ( ( ruleEnumeratorType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6169:1: ( ruleEnumeratorType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6169:1: ( ruleEnumeratorType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6170:1: ruleEnumeratorType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getValuesEnumeratorTypeParserRuleCall_3_1_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_3_1_1_112770);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6179:1: rule__VariantType__NameAssignment_4 : ( ruleSpecialId ) ;
    public final void rule__VariantType__NameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6183:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6184:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6184:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6185:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getNameSpecialIdParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__VariantType__NameAssignment_412801);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6194:1: rule__VariantType__MultiValueAssignment_5 : ( ( '[]' ) ) ;
    public final void rule__VariantType__MultiValueAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6198:1: ( ( ( '[]' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6199:1: ( ( '[]' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6199:1: ( ( '[]' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6200:1: ( '[]' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6201:1: ( '[]' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6202:1: '[]'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_5_0()); 
            }
            match(input,70,FollowSets000.FOLLOW_70_in_rule__VariantType__MultiValueAssignment_512837); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6217:1: rule__VariantType__DefaultAutoAssignment_6_1_0 : ( ( 'AUTO' ) ) ;
    public final void rule__VariantType__DefaultAutoAssignment_6_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6221:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6222:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6222:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6223:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6224:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6225:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDefaultAutoAUTOKeyword_6_1_0_0()); 
            }
            match(input,71,FollowSets000.FOLLOW_71_in_rule__VariantType__DefaultAutoAssignment_6_1_012881); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6240:1: rule__VariantType__DefaultValueAssignment_6_1_1 : ( RULE_ID ) ;
    public final void rule__VariantType__DefaultValueAssignment_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6244:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6245:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6245:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6246:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDefaultValueIDTerminalRuleCall_6_1_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__VariantType__DefaultValueAssignment_6_1_112920); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6255:1: rule__VariantType__DescriptionAssignment_7_1 : ( RULE_STRING ) ;
    public final void rule__VariantType__DescriptionAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6259:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6260:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6260:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6261:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVariantTypeAccess().getDescriptionSTRINGTerminalRuleCall_7_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__VariantType__DescriptionAssignment_7_112951); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6270:1: rule__EnumeratorType__NameAssignment_1 : ( ruleSpecialId ) ;
    public final void rule__EnumeratorType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6274:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6275:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6275:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6276:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getNameSpecialIdParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__EnumeratorType__NameAssignment_112982);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6285:1: rule__EnumeratorType__ParametersAssignment_2_1 : ( ruleParameterType ) ;
    public final void rule__EnumeratorType__ParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6289:1: ( ( ruleParameterType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6290:1: ( ruleParameterType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6290:1: ( ruleParameterType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6291:1: ruleParameterType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getParametersParameterTypeParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameterType_in_rule__EnumeratorType__ParametersAssignment_2_113013);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6300:1: rule__EnumeratorType__DescriptionAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__EnumeratorType__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6304:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6305:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6305:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6306:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEnumeratorTypeAccess().getDescriptionSTRINGTerminalRuleCall_3_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EnumeratorType__DescriptionAssignment_3_113044); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6315:1: rule__ReferenceType__TypeAssignment_1 : ( ruleObjectTypeRef ) ;
    public final void rule__ReferenceType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6319:1: ( ( ruleObjectTypeRef ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6320:1: ( ruleObjectTypeRef )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6320:1: ( ruleObjectTypeRef )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6321:1: ruleObjectTypeRef
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getTypeObjectTypeRefEnumRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectTypeRef_in_rule__ReferenceType__TypeAssignment_113075);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6330:1: rule__ReferenceType__NameAssignment_2 : ( ruleSpecialId ) ;
    public final void rule__ReferenceType__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6334:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6335:1: ( ruleSpecialId )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6335:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6336:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getNameSpecialIdParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__ReferenceType__NameAssignment_213106);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6345:1: rule__ReferenceType__MultiValueAssignment_3 : ( ( '[]' ) ) ;
    public final void rule__ReferenceType__MultiValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6349:1: ( ( ( '[]' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6350:1: ( ( '[]' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6350:1: ( ( '[]' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6351:1: ( '[]' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_3_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6352:1: ( '[]' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6353:1: '[]'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getMultiValueLeftSquareBracketRightSquareBracketKeyword_3_0()); 
            }
            match(input,70,FollowSets000.FOLLOW_70_in_rule__ReferenceType__MultiValueAssignment_313142); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6368:1: rule__ReferenceType__DefaultAutoAssignment_4_1_0 : ( ( 'AUTO' ) ) ;
    public final void rule__ReferenceType__DefaultAutoAssignment_4_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6372:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6373:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6373:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6374:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDefaultAutoAUTOKeyword_4_1_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6375:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6376:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDefaultAutoAUTOKeyword_4_1_0_0()); 
            }
            match(input,71,FollowSets000.FOLLOW_71_in_rule__ReferenceType__DefaultAutoAssignment_4_1_013186); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6391:1: rule__ReferenceType__DefaultValueAssignment_4_1_1 : ( RULE_ID ) ;
    public final void rule__ReferenceType__DefaultValueAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6395:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6396:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6396:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6397:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDefaultValueIDTerminalRuleCall_4_1_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReferenceType__DefaultValueAssignment_4_1_113225); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6406:1: rule__ReferenceType__DescriptionAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__ReferenceType__DescriptionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6410:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6411:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6411:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6412:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceTypeAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ReferenceType__DescriptionAssignment_5_113256); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6421:1: rule__OilObject__TypeAssignment_0 : ( ruleObjectType ) ;
    public final void rule__OilObject__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6425:1: ( ( ruleObjectType ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6426:1: ( ruleObjectType )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6426:1: ( ruleObjectType )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6427:1: ruleObjectType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getTypeObjectTypeEnumRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleObjectType_in_rule__OilObject__TypeAssignment_013287);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6436:1: rule__OilObject__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OilObject__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6440:1: ( ( RULE_ID ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6441:1: ( RULE_ID )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6441:1: ( RULE_ID )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6442:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__OilObject__NameAssignment_113318); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6451:1: rule__OilObject__ParametersAssignment_2_1 : ( ruleParameter ) ;
    public final void rule__OilObject__ParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6455:1: ( ( ruleParameter ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6456:1: ( ruleParameter )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6456:1: ( ruleParameter )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6457:1: ruleParameter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getParametersParameterParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_rule__OilObject__ParametersAssignment_2_113349);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6466:1: rule__OilObject__DescriptionAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__OilObject__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6470:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6471:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6471:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6472:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOilObjectAccess().getDescriptionSTRINGTerminalRuleCall_3_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__OilObject__DescriptionAssignment_3_113380); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6481:1: rule__Parameter__TypeAssignment_1 : ( ( ruleSpecialId ) ) ;
    public final void rule__Parameter__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6485:1: ( ( ( ruleSpecialId ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6486:1: ( ( ruleSpecialId ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6486:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6487:1: ( ruleSpecialId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeParameterTypeCrossReference_1_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6488:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6489:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getTypeParameterTypeSpecialIdParserRuleCall_1_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__Parameter__TypeAssignment_113415);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6500:1: rule__Parameter__AutoAssignment_3_0 : ( ( 'AUTO' ) ) ;
    public final void rule__Parameter__AutoAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6504:1: ( ( ( 'AUTO' ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6505:1: ( ( 'AUTO' ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6505:1: ( ( 'AUTO' ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6506:1: ( 'AUTO' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getAutoAUTOKeyword_3_0_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6507:1: ( 'AUTO' )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6508:1: 'AUTO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getAutoAUTOKeyword_3_0_0()); 
            }
            match(input,71,FollowSets000.FOLLOW_71_in_rule__Parameter__AutoAssignment_3_013455); if (state.failed) return ;
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6523:1: rule__Parameter__ValueAssignment_3_1 : ( ruleGenericValue ) ;
    public final void rule__Parameter__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6527:1: ( ( ruleGenericValue ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6528:1: ( ruleGenericValue )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6528:1: ( ruleGenericValue )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6529:1: ruleGenericValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getValueGenericValueParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGenericValue_in_rule__Parameter__ValueAssignment_3_113494);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6538:1: rule__Parameter__ValueRefAssignment_3_2 : ( ( ruleSpecialId ) ) ;
    public final void rule__Parameter__ValueRefAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6542:1: ( ( ( ruleSpecialId ) ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6543:1: ( ( ruleSpecialId ) )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6543:1: ( ( ruleSpecialId ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6544:1: ( ruleSpecialId )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getValueRefParameterRefCrossReference_3_2_0()); 
            }
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6545:1: ( ruleSpecialId )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6546:1: ruleSpecialId
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getValueRefParameterRefSpecialIdParserRuleCall_3_2_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSpecialId_in_rule__Parameter__ValueRefAssignment_3_213529);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6557:1: rule__Parameter__ParametersAssignment_4_1 : ( ruleParameter ) ;
    public final void rule__Parameter__ParametersAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6561:1: ( ( ruleParameter ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6562:1: ( ruleParameter )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6562:1: ( ruleParameter )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6563:1: ruleParameter
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getParametersParameterParserRuleCall_4_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_rule__Parameter__ParametersAssignment_4_113564);
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
    // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6572:1: rule__Parameter__DescriptionAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__Parameter__DescriptionAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6576:1: ( ( RULE_STRING ) )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6577:1: ( RULE_STRING )
            {
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6577:1: ( RULE_STRING )
            // ../plugin_rtd_oil_ui/src_xtext/src-gen/com/eu/evidence/rtdruid/oil/xtext/ui/contentassist/antlr/internal/InternalOil.g:6578:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Parameter__DescriptionAssignment_5_113595); if (state.failed) return ;
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
        "\4\6\2\100\3\6\2\uffff\4\6";
    static final String DFA2_maxS =
        "\1\65\2\10\2\104\1\103\2\104\1\10\2\uffff\4\103";
    static final String DFA2_acceptS =
        "\11\uffff\1\2\1\1\4\uffff";
    static final String DFA2_specialS =
        "\17\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\4\1\5\1\3\53\uffff\1\1\1\2",
            "\1\4\1\5\1\3",
            "\1\4\1\5\1\3",
            "\1\6\1\uffff\1\7\67\uffff\1\11\1\12\1\uffff\1\11\1\10",
            "\1\11\1\12\1\uffff\1\11\1\10",
            "\1\11\1\12\1\uffff\1\11",
            "\1\6\1\uffff\1\7\67\uffff\1\11\1\12\1\uffff\1\11\1\10",
            "\1\6\1\uffff\1\7\67\uffff\1\11\1\12\1\uffff\1\11\1\10",
            "\1\13\1\uffff\1\14",
            "",
            "",
            "\1\15\1\uffff\1\16\67\uffff\1\11\1\12\1\uffff\1\11",
            "\1\15\1\uffff\1\16\67\uffff\1\11\1\12\1\uffff\1\11",
            "\1\15\1\uffff\1\16\67\uffff\1\11\1\12\1\uffff\1\11",
            "\1\15\1\uffff\1\16\67\uffff\1\11\1\12\1\uffff\1\11"
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
        "\1\5\1\uffff\3\6\1\72\1\uffff\2\6\1\uffff";
    static final String DFA9_maxS =
        "\1\65\1\uffff\2\10\2\104\1\uffff\2\104\1\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\2\uffff\1\3";
    static final String DFA9_specialS =
        "\12\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\1\1\5\1\6\1\4\53\uffff\1\2\1\3",
            "",
            "\1\5\1\6\1\4",
            "\1\5\1\6\1\4",
            "\1\7\1\uffff\1\10\61\uffff\1\6\1\uffff\1\6\1\uffff\1\6\5\uffff"+
            "\1\11",
            "\1\6\1\uffff\1\6\1\uffff\1\6\5\uffff\1\11",
            "",
            "\1\7\1\uffff\1\10\61\uffff\1\6\1\uffff\1\6\1\uffff\1\6\5\uffff"+
            "\1\11",
            "\1\7\1\uffff\1\10\61\uffff\1\6\1\uffff\1\6\1\uffff\1\6\5\uffff"+
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
            return "1155:1: rule__GenericValue__Alternatives : ( ( RULE_STRING ) | ( ruleINT ) | ( ruleFLOAT ) );";
        }
    }
    static final String DFA10_eotS =
        "\11\uffff";
    static final String DFA10_eofS =
        "\3\uffff\2\5\1\uffff\2\5\1\uffff";
    static final String DFA10_minS =
        "\4\6\1\100\1\uffff\2\6\1\uffff";
    static final String DFA10_maxS =
        "\1\65\2\10\2\104\1\uffff\2\104\1\uffff";
    static final String DFA10_acceptS =
        "\5\uffff\1\1\2\uffff\1\2";
    static final String DFA10_specialS =
        "\11\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\4\1\5\1\3\53\uffff\1\1\1\2",
            "\1\4\1\5\1\3",
            "\1\4\1\5\1\3",
            "\1\6\1\uffff\1\7\67\uffff\2\5\1\uffff\1\5\1\10",
            "\2\5\1\uffff\1\5\1\10",
            "",
            "\1\6\1\uffff\1\7\67\uffff\2\5\1\uffff\1\5\1\10",
            "\1\6\1\uffff\1\7\67\uffff\2\5\1\uffff\1\5\1\10",
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
            return "1183:1: rule__GenericNumber__Alternatives : ( ( ruleINT ) | ( ruleFLOAT ) );";
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
        public static final BitSet FOLLOW_14_in_rule__SpecialId__Alternatives1764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__SpecialId__Alternatives1784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__SpecialId__Alternatives1804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__SpecialId__Alternatives1824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__SpecialId__Alternatives1844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__SpecialId__Alternatives1864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__SpecialId__Alternatives1884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__SpecialId__Alternatives1904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__SpecialId__Alternatives1924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__SpecialId__Alternatives1944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__SpecialId__Alternatives1964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__SpecialId__Alternatives1984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__SpecialId__Alternatives2004 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__SpecialId__Alternatives2024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__SpecialId__Alternatives2044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__SpecialId__Alternatives2064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__SpecialId__Alternatives2084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__SpecialId__Alternatives2104 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__SpecialId__Alternatives2124 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__SpecialId__Alternatives2144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__SpecialId__Alternatives2164 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__SpecialId__Alternatives2184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__SpecialId__Alternatives2204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__SpecialId__Alternatives2224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__SpecialId__Alternatives2244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__SpecialId__Alternatives2264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__SpecialId__Alternatives2284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__SpecialId__Alternatives2304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__SpecialId__Alternatives2324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_rule__SpecialId__Alternatives2344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_rule__SpecialId__Alternatives2364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_rule__SpecialId__Alternatives2384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_rule__SpecialId__Alternatives2404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_rule__SpecialId__Alternatives2424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_rule__SpecialId__Alternatives2444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_rule__SpecialId__Alternatives2464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_rule__SpecialId__Alternatives2484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_rule__SpecialId__Alternatives2504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__GenericValue__Alternatives2538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_rule__GenericValue__Alternatives2555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFLOAT_in_rule__GenericValue__Alternatives2572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT_in_rule__GenericNumber__Alternatives2604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFLOAT_in_rule__GenericNumber__Alternatives2621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__INT__Alternatives_02654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__INT__Alternatives_02674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__0_in_rule__INT__Alternatives_12708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__INT__Alternatives_12726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_HEX_in_rule__INT__Alternatives_12743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__INT__Alternatives_1_0_12775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Alternatives_1_0_12792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_rule__FLOAT__Alternatives_02825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_rule__FLOAT__Alternatives_02845 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__FLOAT__Alternatives_12879 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Group_1_1__0_in_rule__FLOAT__Alternatives_12896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__FLOAT__Alternatives_1_1_12929 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__FLOAT__Alternatives_1_1_12946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ZERO_INT_in_rule__FLOAT__Alternatives_32978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__FLOAT__Alternatives_32995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__VType__Alternatives3028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__VType__Alternatives3049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__VType__Alternatives3070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__VType__Alternatives3091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__VType__Alternatives3112 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__VType__Alternatives3133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__EType__Alternatives3169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__EType__Alternatives3190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__ObjectType__Alternatives3226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__ObjectType__Alternatives3247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__ObjectType__Alternatives3268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__ObjectType__Alternatives3289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__ObjectType__Alternatives3310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__ObjectType__Alternatives3331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__ObjectType__Alternatives3352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__ObjectType__Alternatives3373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__ObjectType__Alternatives3394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__ObjectType__Alternatives3415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__ObjectType__Alternatives3436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__ObjectType__Alternatives3457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__ObjectType__Alternatives3478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rule__ObjectType__Alternatives3499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__ObjectType__Alternatives3520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__ObjectType__Alternatives3541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__ObjectTypeRef__Alternatives3577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__ObjectTypeRef__Alternatives3598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__ObjectTypeRef__Alternatives3619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__ObjectTypeRef__Alternatives3640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__ObjectTypeRef__Alternatives3661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__ObjectTypeRef__Alternatives3682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_rule__ObjectTypeRef__Alternatives3703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_rule__ObjectTypeRef__Alternatives3724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_rule__ObjectTypeRef__Alternatives3745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_rule__ObjectTypeRef__Alternatives3766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_rule__ObjectTypeRef__Alternatives3787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_rule__ObjectTypeRef__Alternatives3808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_rule__ObjectTypeRef__Alternatives3829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rule__ObjectTypeRef__Alternatives3850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_rule__ObjectTypeRef__Alternatives3871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_rule__ObjectTypeRef__Alternatives3892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__0__Impl_in_rule__OilFile__Group__03925 = new BitSet(new long[]{0x8900000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group__1_in_rule__OilFile__Group__03928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__1__Impl_in_rule__OilFile__Group__13986 = new BitSet(new long[]{0x8900000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group__2_in_rule__OilFile__Group__13989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__0_in_rule__OilFile__Group__1__Impl4016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__2__Impl_in_rule__OilFile__Group__24047 = new BitSet(new long[]{0x8900000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group__3_in_rule__OilFile__Group__24050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__ImplementationAssignment_2_in_rule__OilFile__Group__2__Impl4077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group__3__Impl_in_rule__OilFile__Group__34108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__ApplicationAssignment_3_in_rule__OilFile__Group__3__Impl4135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__0__Impl_in_rule__OilFile__Group_1__04174 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__1_in_rule__OilFile__Group_1__04177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rule__OilFile__Group_1__0__Impl4205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__1__Impl_in_rule__OilFile__Group_1__14236 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__2_in_rule__OilFile__Group_1__14239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__OilFile__Group_1__1__Impl4267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__2__Impl_in_rule__OilFile__Group_1__24298 = new BitSet(new long[]{0x0400000000000000L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__3_in_rule__OilFile__Group_1__24301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__OilVersionAssignment_1_2_in_rule__OilFile__Group_1__2__Impl4328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilFile__Group_1__3__Impl_in_rule__OilFile__Group_1__34358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__OilFile__Group_1__3__Impl4386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__0__Impl_in_rule__OilImplementation__Group__04425 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__1_in_rule__OilImplementation__Group__04428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_rule__OilImplementation__Group__0__Impl4456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__1__Impl_in_rule__OilImplementation__Group__14487 = new BitSet(new long[]{0x1000000000000000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__2_in_rule__OilImplementation__Group__14490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__NameAssignment_1_in_rule__OilImplementation__Group__1__Impl4517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__2__Impl_in_rule__OilImplementation__Group__24547 = new BitSet(new long[]{0x2040001FFFC00000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__3_in_rule__OilImplementation__Group__24550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rule__OilImplementation__Group__2__Impl4578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__3__Impl_in_rule__OilImplementation__Group__34609 = new BitSet(new long[]{0x2040001FFFC00000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__4_in_rule__OilImplementation__Group__34612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__OilObjectsAssignment_3_in_rule__OilImplementation__Group__3__Impl4639 = new BitSet(new long[]{0x0040001FFFC00002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__4__Impl_in_rule__OilImplementation__Group__44670 = new BitSet(new long[]{0x0400000000000000L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__5_in_rule__OilImplementation__Group__44673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rule__OilImplementation__Group__4__Impl4701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilImplementation__Group__5__Impl_in_rule__OilImplementation__Group__54732 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__OilImplementation__Group__5__Impl4760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__0__Impl_in_rule__OilObjectImpl__Group__04803 = new BitSet(new long[]{0x1000000000000000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__1_in_rule__OilObjectImpl__Group__04806 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__TypeAssignment_0_in_rule__OilObjectImpl__Group__0__Impl4833 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__1__Impl_in_rule__OilObjectImpl__Group__14863 = new BitSet(new long[]{0x208FFFE0003FC000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__2_in_rule__OilObjectImpl__Group__14866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rule__OilObjectImpl__Group__1__Impl4894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__2__Impl_in_rule__OilObjectImpl__Group__24925 = new BitSet(new long[]{0x208FFFE0003FC000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__3_in_rule__OilObjectImpl__Group__24928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__ParametersAssignment_2_in_rule__OilObjectImpl__Group__2__Impl4955 = new BitSet(new long[]{0x008FFFE0003FC002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__3__Impl_in_rule__OilObjectImpl__Group__34986 = new BitSet(new long[]{0x4400000000000000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__4_in_rule__OilObjectImpl__Group__34989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rule__OilObjectImpl__Group__3__Impl5017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__4__Impl_in_rule__OilObjectImpl__Group__45048 = new BitSet(new long[]{0x4400000000000000L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__5_in_rule__OilObjectImpl__Group__45051 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__0_in_rule__OilObjectImpl__Group__4__Impl5078 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group__5__Impl_in_rule__OilObjectImpl__Group__55109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__OilObjectImpl__Group__5__Impl5137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__0__Impl_in_rule__OilObjectImpl__Group_4__05180 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__1_in_rule__OilObjectImpl__Group_4__05183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rule__OilObjectImpl__Group_4__0__Impl5211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__Group_4__1__Impl_in_rule__OilObjectImpl__Group_4__15242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObjectImpl__DescriptionAssignment_4_1_in_rule__OilObjectImpl__Group_4__1__Impl5269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__0__Impl_in_rule__OilApplication__Group__05303 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__1_in_rule__OilApplication__Group__05306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_rule__OilApplication__Group__0__Impl5334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__1__Impl_in_rule__OilApplication__Group__15365 = new BitSet(new long[]{0x1000000000000000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__2_in_rule__OilApplication__Group__15368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__NameAssignment_1_in_rule__OilApplication__Group__1__Impl5395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__2__Impl_in_rule__OilApplication__Group__25425 = new BitSet(new long[]{0x2040001FFFC00000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__3_in_rule__OilApplication__Group__25428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rule__OilApplication__Group__2__Impl5456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__3__Impl_in_rule__OilApplication__Group__35487 = new BitSet(new long[]{0x2040001FFFC00000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__4_in_rule__OilApplication__Group__35490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__OilObjectsAssignment_3_in_rule__OilApplication__Group__3__Impl5517 = new BitSet(new long[]{0x0040001FFFC00002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__4__Impl_in_rule__OilApplication__Group__45548 = new BitSet(new long[]{0x4400000000000000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__5_in_rule__OilApplication__Group__45551 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rule__OilApplication__Group__4__Impl5579 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__5__Impl_in_rule__OilApplication__Group__55610 = new BitSet(new long[]{0x4400000000000000L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__6_in_rule__OilApplication__Group__55613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__0_in_rule__OilApplication__Group__5__Impl5640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group__6__Impl_in_rule__OilApplication__Group__65671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__OilApplication__Group__6__Impl5699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__0__Impl_in_rule__OilApplication__Group_5__05744 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__1_in_rule__OilApplication__Group_5__05747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rule__OilApplication__Group_5__0__Impl5775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__Group_5__1__Impl_in_rule__OilApplication__Group_5__15806 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilApplication__DescriptionAssignment_5_1_in_rule__OilApplication__Group_5__1__Impl5833 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueList__Group__0__Impl_in_rule__ValueList__Group__05867 = new BitSet(new long[]{0x00300000000001C0L});
        public static final BitSet FOLLOW_rule__ValueList__Group__1_in_rule__ValueList__Group__05870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueList__Group__1__Impl_in_rule__ValueList__Group__15928 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__ValueList__Group__2_in_rule__ValueList__Group__15931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueList__ValuesAssignment_1_in_rule__ValueList__Group__1__Impl5958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueList__Group__2__Impl_in_rule__ValueList__Group__25988 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueList__Group_2__0_in_rule__ValueList__Group__2__Impl6015 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__ValueList__Group_2__0__Impl_in_rule__ValueList__Group_2__06052 = new BitSet(new long[]{0x00300000000001C0L});
        public static final BitSet FOLLOW_rule__ValueList__Group_2__1_in_rule__ValueList__Group_2__06055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_rule__ValueList__Group_2__0__Impl6083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueList__Group_2__1__Impl_in_rule__ValueList__Group_2__16114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueList__ValuesAssignment_2_1_in_rule__ValueList__Group_2__1__Impl6141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Range__Group__0__Impl_in_rule__Range__Group__06175 = new BitSet(new long[]{0x00300000000001C0L});
        public static final BitSet FOLLOW_rule__Range__Group__1_in_rule__Range__Group__06178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Range__Group__1__Impl_in_rule__Range__Group__16236 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Range__Group__2_in_rule__Range__Group__16239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Range__MinAssignment_1_in_rule__Range__Group__1__Impl6266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Range__Group__2__Impl_in_rule__Range__Group__26296 = new BitSet(new long[]{0x00300000000001C0L});
        public static final BitSet FOLLOW_rule__Range__Group__3_in_rule__Range__Group__26299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_rule__Range__Group__2__Impl6327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Range__Group__3__Impl_in_rule__Range__Group__36358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Range__MaxAssignment_3_in_rule__Range__Group__3__Impl6385 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__0__Impl_in_rule__ValueType__Group__06423 = new BitSet(new long[]{0x00000000000FC000L});
        public static final BitSet FOLLOW_rule__ValueType__Group__1_in_rule__ValueType__Group__06426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__1__Impl_in_rule__ValueType__Group__16484 = new BitSet(new long[]{0x000FFFFFFFFFC010L,0x0000000000000024L});
        public static final BitSet FOLLOW_rule__ValueType__Group__2_in_rule__ValueType__Group__16487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__TypeAssignment_1_in_rule__ValueType__Group__1__Impl6514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__2__Impl_in_rule__ValueType__Group__26544 = new BitSet(new long[]{0x000FFFFFFFFFC010L,0x0000000000000024L});
        public static final BitSet FOLLOW_rule__ValueType__Group__3_in_rule__ValueType__Group__26547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__WithAutoAssignment_2_in_rule__ValueType__Group__2__Impl6574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__3__Impl_in_rule__ValueType__Group__36605 = new BitSet(new long[]{0x000FFFFFFFFFC010L,0x0000000000000024L});
        public static final BitSet FOLLOW_rule__ValueType__Group__4_in_rule__ValueType__Group__36608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3__0_in_rule__ValueType__Group__3__Impl6635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__4__Impl_in_rule__ValueType__Group__46666 = new BitSet(new long[]{0x4600000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_rule__ValueType__Group__5_in_rule__ValueType__Group__46669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__NameAssignment_4_in_rule__ValueType__Group__4__Impl6696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__5__Impl_in_rule__ValueType__Group__56726 = new BitSet(new long[]{0x4600000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_rule__ValueType__Group__6_in_rule__ValueType__Group__56729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__MultiValueAssignment_5_in_rule__ValueType__Group__5__Impl6756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__6__Impl_in_rule__ValueType__Group__66787 = new BitSet(new long[]{0x4600000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_rule__ValueType__Group__7_in_rule__ValueType__Group__66790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__0_in_rule__ValueType__Group__6__Impl6817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__7__Impl_in_rule__ValueType__Group__76848 = new BitSet(new long[]{0x4600000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_rule__ValueType__Group__8_in_rule__ValueType__Group__76851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_7__0_in_rule__ValueType__Group__7__Impl6878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group__8__Impl_in_rule__ValueType__Group__86909 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__ValueType__Group__8__Impl6937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3__0__Impl_in_rule__ValueType__Group_3__06986 = new BitSet(new long[]{0x00300000000001C0L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3__1_in_rule__ValueType__Group_3__06989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_rule__ValueType__Group_3__0__Impl7017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3__1__Impl_in_rule__ValueType__Group_3__17048 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3__2_in_rule__ValueType__Group_3__17051 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__ValidValuesAssignment_3_1_in_rule__ValueType__Group_3__1__Impl7078 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_3__2__Impl_in_rule__ValueType__Group_3__27108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_rule__ValueType__Group_3__2__Impl7136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__0__Impl_in_rule__ValueType__Group_6__07173 = new BitSet(new long[]{0x00300000000001F0L,0x0000000000000080L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__1_in_rule__ValueType__Group_6__07176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__ValueType__Group_6__0__Impl7204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_6__1__Impl_in_rule__ValueType__Group_6__17235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Alternatives_6_1_in_rule__ValueType__Group_6__1__Impl7262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_7__0__Impl_in_rule__ValueType__Group_7__07296 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ValueType__Group_7__1_in_rule__ValueType__Group_7__07299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rule__ValueType__Group_7__0__Impl7327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__Group_7__1__Impl_in_rule__ValueType__Group_7__17358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__DescriptionAssignment_7_1_in_rule__ValueType__Group_7__1__Impl7385 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__0__Impl_in_rule__VariantType__Group__07419 = new BitSet(new long[]{0x0000000000300000L});
        public static final BitSet FOLLOW_rule__VariantType__Group__1_in_rule__VariantType__Group__07422 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__1__Impl_in_rule__VariantType__Group__17480 = new BitSet(new long[]{0x000FFFFFFFFFC010L,0x0000000000000024L});
        public static final BitSet FOLLOW_rule__VariantType__Group__2_in_rule__VariantType__Group__17483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__TypeAssignment_1_in_rule__VariantType__Group__1__Impl7510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__2__Impl_in_rule__VariantType__Group__27540 = new BitSet(new long[]{0x000FFFFFFFFFC010L,0x0000000000000024L});
        public static final BitSet FOLLOW_rule__VariantType__Group__3_in_rule__VariantType__Group__27543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__WithAutoAssignment_2_in_rule__VariantType__Group__2__Impl7570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__3__Impl_in_rule__VariantType__Group__37601 = new BitSet(new long[]{0x000FFFFFFFFFC010L,0x0000000000000024L});
        public static final BitSet FOLLOW_rule__VariantType__Group__4_in_rule__VariantType__Group__37604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__0_in_rule__VariantType__Group__3__Impl7631 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__4__Impl_in_rule__VariantType__Group__47662 = new BitSet(new long[]{0x4600000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_rule__VariantType__Group__5_in_rule__VariantType__Group__47665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__NameAssignment_4_in_rule__VariantType__Group__4__Impl7692 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__5__Impl_in_rule__VariantType__Group__57722 = new BitSet(new long[]{0x4600000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_rule__VariantType__Group__6_in_rule__VariantType__Group__57725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__MultiValueAssignment_5_in_rule__VariantType__Group__5__Impl7752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__6__Impl_in_rule__VariantType__Group__67783 = new BitSet(new long[]{0x4600000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_rule__VariantType__Group__7_in_rule__VariantType__Group__67786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__0_in_rule__VariantType__Group__6__Impl7813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__7__Impl_in_rule__VariantType__Group__77844 = new BitSet(new long[]{0x4600000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_rule__VariantType__Group__8_in_rule__VariantType__Group__77847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__0_in_rule__VariantType__Group__7__Impl7874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group__8__Impl_in_rule__VariantType__Group__87905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__VariantType__Group__8__Impl7933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__0__Impl_in_rule__VariantType__Group_3__07982 = new BitSet(new long[]{0x000FFFFFFFFFC010L,0x000000000000002CL});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__1_in_rule__VariantType__Group_3__07985 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_rule__VariantType__Group_3__0__Impl8013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__1__Impl_in_rule__VariantType__Group_3__18044 = new BitSet(new long[]{0x000FFFFFFFFFC010L,0x000000000000002CL});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__2_in_rule__VariantType__Group_3__18047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1__0_in_rule__VariantType__Group_3__1__Impl8074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3__2__Impl_in_rule__VariantType__Group_3__28105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_rule__VariantType__Group_3__2__Impl8133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1__0__Impl_in_rule__VariantType__Group_3_1__08170 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1__1_in_rule__VariantType__Group_3_1__08173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__ValuesAssignment_3_1_0_in_rule__VariantType__Group_3_1__0__Impl8200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1__1__Impl_in_rule__VariantType__Group_3_1__18230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1_1__0_in_rule__VariantType__Group_3_1__1__Impl8257 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1_1__0__Impl_in_rule__VariantType__Group_3_1_1__08292 = new BitSet(new long[]{0x000FFFFFFFFFC010L,0x0000000000000024L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1_1__1_in_rule__VariantType__Group_3_1_1__08295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_rule__VariantType__Group_3_1_1__0__Impl8323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_3_1_1__1__Impl_in_rule__VariantType__Group_3_1_1__18354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__ValuesAssignment_3_1_1_1_in_rule__VariantType__Group_3_1_1__1__Impl8381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__0__Impl_in_rule__VariantType__Group_6__08415 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000080L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__1_in_rule__VariantType__Group_6__08418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__VariantType__Group_6__0__Impl8446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_6__1__Impl_in_rule__VariantType__Group_6__18477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Alternatives_6_1_in_rule__VariantType__Group_6__1__Impl8504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__0__Impl_in_rule__VariantType__Group_7__08538 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__1_in_rule__VariantType__Group_7__08541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rule__VariantType__Group_7__0__Impl8569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__Group_7__1__Impl_in_rule__VariantType__Group_7__18600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariantType__DescriptionAssignment_7_1_in_rule__VariantType__Group_7__1__Impl8627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__0__Impl_in_rule__EnumeratorType__Group__08661 = new BitSet(new long[]{0x000FFFFFFFFFC010L,0x0000000000000024L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__1_in_rule__EnumeratorType__Group__08664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__1__Impl_in_rule__EnumeratorType__Group__18722 = new BitSet(new long[]{0x5000000000000000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__2_in_rule__EnumeratorType__Group__18725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__NameAssignment_1_in_rule__EnumeratorType__Group__1__Impl8752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__2__Impl_in_rule__EnumeratorType__Group__28782 = new BitSet(new long[]{0x5000000000000000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__3_in_rule__EnumeratorType__Group__28785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__0_in_rule__EnumeratorType__Group__2__Impl8812 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group__3__Impl_in_rule__EnumeratorType__Group__38843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__0_in_rule__EnumeratorType__Group__3__Impl8870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__0__Impl_in_rule__EnumeratorType__Group_2__08909 = new BitSet(new long[]{0x208FFFE0003FC000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__1_in_rule__EnumeratorType__Group_2__08912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rule__EnumeratorType__Group_2__0__Impl8940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__1__Impl_in_rule__EnumeratorType__Group_2__18971 = new BitSet(new long[]{0x208FFFE0003FC000L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__2_in_rule__EnumeratorType__Group_2__18974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__ParametersAssignment_2_1_in_rule__EnumeratorType__Group_2__1__Impl9001 = new BitSet(new long[]{0x008FFFE0003FC002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_2__2__Impl_in_rule__EnumeratorType__Group_2__29032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rule__EnumeratorType__Group_2__2__Impl9060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__0__Impl_in_rule__EnumeratorType__Group_3__09097 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__1_in_rule__EnumeratorType__Group_3__09100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rule__EnumeratorType__Group_3__0__Impl9128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__Group_3__1__Impl_in_rule__EnumeratorType__Group_3__19159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumeratorType__DescriptionAssignment_3_1_in_rule__EnumeratorType__Group_3__1__Impl9186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__0__Impl_in_rule__ReferenceType__Group__09220 = new BitSet(new long[]{0x008FFFE0003FC000L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__1_in_rule__ReferenceType__Group__09223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__1__Impl_in_rule__ReferenceType__Group__19281 = new BitSet(new long[]{0x000FFFFFFFFFC010L,0x0000000000000024L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__2_in_rule__ReferenceType__Group__19284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__TypeAssignment_1_in_rule__ReferenceType__Group__1__Impl9311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__2__Impl_in_rule__ReferenceType__Group__29341 = new BitSet(new long[]{0x4600000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__3_in_rule__ReferenceType__Group__29344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__NameAssignment_2_in_rule__ReferenceType__Group__2__Impl9371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__3__Impl_in_rule__ReferenceType__Group__39401 = new BitSet(new long[]{0x4600000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__4_in_rule__ReferenceType__Group__39404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__MultiValueAssignment_3_in_rule__ReferenceType__Group__3__Impl9431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__4__Impl_in_rule__ReferenceType__Group__49462 = new BitSet(new long[]{0x4600000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__5_in_rule__ReferenceType__Group__49465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_4__0_in_rule__ReferenceType__Group__4__Impl9492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__5__Impl_in_rule__ReferenceType__Group__59523 = new BitSet(new long[]{0x4600000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__6_in_rule__ReferenceType__Group__59526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__0_in_rule__ReferenceType__Group__5__Impl9553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group__6__Impl_in_rule__ReferenceType__Group__69584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__ReferenceType__Group__6__Impl9612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_4__0__Impl_in_rule__ReferenceType__Group_4__09657 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000080L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_4__1_in_rule__ReferenceType__Group_4__09660 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__ReferenceType__Group_4__0__Impl9688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_4__1__Impl_in_rule__ReferenceType__Group_4__19719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Alternatives_4_1_in_rule__ReferenceType__Group_4__1__Impl9746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__0__Impl_in_rule__ReferenceType__Group_5__09780 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__1_in_rule__ReferenceType__Group_5__09783 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rule__ReferenceType__Group_5__0__Impl9811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__Group_5__1__Impl_in_rule__ReferenceType__Group_5__19842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReferenceType__DescriptionAssignment_5_1_in_rule__ReferenceType__Group_5__1__Impl9869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__0__Impl_in_rule__OilObject__Group__09903 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__OilObject__Group__1_in_rule__OilObject__Group__09906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__TypeAssignment_0_in_rule__OilObject__Group__0__Impl9933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__1__Impl_in_rule__OilObject__Group__19963 = new BitSet(new long[]{0x5400000000000000L});
        public static final BitSet FOLLOW_rule__OilObject__Group__2_in_rule__OilObject__Group__19966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__NameAssignment_1_in_rule__OilObject__Group__1__Impl9993 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__2__Impl_in_rule__OilObject__Group__210023 = new BitSet(new long[]{0x5400000000000000L});
        public static final BitSet FOLLOW_rule__OilObject__Group__3_in_rule__OilObject__Group__210026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_2__0_in_rule__OilObject__Group__2__Impl10053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__3__Impl_in_rule__OilObject__Group__310084 = new BitSet(new long[]{0x5400000000000000L});
        public static final BitSet FOLLOW_rule__OilObject__Group__4_in_rule__OilObject__Group__310087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_3__0_in_rule__OilObject__Group__3__Impl10114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group__4__Impl_in_rule__OilObject__Group__410145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__OilObject__Group__4__Impl10173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_2__0__Impl_in_rule__OilObject__Group_2__010214 = new BitSet(new long[]{0x200FFFFFFFFFC010L,0x0000000000000024L});
        public static final BitSet FOLLOW_rule__OilObject__Group_2__1_in_rule__OilObject__Group_2__010217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rule__OilObject__Group_2__0__Impl10245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_2__1__Impl_in_rule__OilObject__Group_2__110276 = new BitSet(new long[]{0x200FFFFFFFFFC010L,0x0000000000000024L});
        public static final BitSet FOLLOW_rule__OilObject__Group_2__2_in_rule__OilObject__Group_2__110279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__ParametersAssignment_2_1_in_rule__OilObject__Group_2__1__Impl10306 = new BitSet(new long[]{0x000FFFFFFFFFC012L,0x0000000000000024L});
        public static final BitSet FOLLOW_rule__OilObject__Group_2__2__Impl_in_rule__OilObject__Group_2__210337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rule__OilObject__Group_2__2__Impl10365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_3__0__Impl_in_rule__OilObject__Group_3__010402 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__OilObject__Group_3__1_in_rule__OilObject__Group_3__010405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rule__OilObject__Group_3__0__Impl10433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__Group_3__1__Impl_in_rule__OilObject__Group_3__110464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OilObject__DescriptionAssignment_3_1_in_rule__OilObject__Group_3__1__Impl10491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__010525 = new BitSet(new long[]{0x000FFFFFFFFFC010L,0x0000000000000024L});
        public static final BitSet FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__010528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__110586 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__110589 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__TypeAssignment_1_in_rule__Parameter__Group__1__Impl10616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__210646 = new BitSet(new long[]{0x003FFFFFFFFFC1F0L,0x00000000000000A4L});
        public static final BitSet FOLLOW_rule__Parameter__Group__3_in_rule__Parameter__Group__210649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rule__Parameter__Group__2__Impl10677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__3__Impl_in_rule__Parameter__Group__310708 = new BitSet(new long[]{0x5400000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__4_in_rule__Parameter__Group__310711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Alternatives_3_in_rule__Parameter__Group__3__Impl10738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__4__Impl_in_rule__Parameter__Group__410768 = new BitSet(new long[]{0x5400000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__5_in_rule__Parameter__Group__410771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__0_in_rule__Parameter__Group__4__Impl10798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__5__Impl_in_rule__Parameter__Group__510829 = new BitSet(new long[]{0x5400000000000000L});
        public static final BitSet FOLLOW_rule__Parameter__Group__6_in_rule__Parameter__Group__510832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__0_in_rule__Parameter__Group__5__Impl10859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__6__Impl_in_rule__Parameter__Group__610890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rule__Parameter__Group__6__Impl10918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__0__Impl_in_rule__Parameter__Group_4__010963 = new BitSet(new long[]{0x200FFFFFFFFFC010L,0x0000000000000024L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__1_in_rule__Parameter__Group_4__010966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rule__Parameter__Group_4__0__Impl10994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__1__Impl_in_rule__Parameter__Group_4__111025 = new BitSet(new long[]{0x200FFFFFFFFFC010L,0x0000000000000024L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__2_in_rule__Parameter__Group_4__111028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__ParametersAssignment_4_1_in_rule__Parameter__Group_4__1__Impl11055 = new BitSet(new long[]{0x000FFFFFFFFFC012L,0x0000000000000024L});
        public static final BitSet FOLLOW_rule__Parameter__Group_4__2__Impl_in_rule__Parameter__Group_4__211086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rule__Parameter__Group_4__2__Impl11114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__0__Impl_in_rule__Parameter__Group_5__011151 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__1_in_rule__Parameter__Group_5__011154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_rule__Parameter__Group_5__0__Impl11182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group_5__1__Impl_in_rule__Parameter__Group_5__111213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__DescriptionAssignment_5_1_in_rule__Parameter__Group_5__1__Impl11240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group__0__Impl_in_rule__INT__Group__011274 = new BitSet(new long[]{0x00300000000001C0L});
        public static final BitSet FOLLOW_rule__INT__Group__1_in_rule__INT__Group__011277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Alternatives_0_in_rule__INT__Group__0__Impl11304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group__1__Impl_in_rule__INT__Group__111335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Alternatives_1_in_rule__INT__Group__1__Impl11362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__0__Impl_in_rule__INT__Group_1_0__011396 = new BitSet(new long[]{0x0000000000000140L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__1_in_rule__INT__Group_1_0__011399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__INT__Group_1_0__0__Impl11426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Group_1_0__1__Impl_in_rule__INT__Group_1_0__111455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__INT__Alternatives_1_0_1_in_rule__INT__Group_1_0__1__Impl11482 = new BitSet(new long[]{0x0000000000000142L});
        public static final BitSet FOLLOW_rule__FLOAT__Group__0__Impl_in_rule__FLOAT__Group__011517 = new BitSet(new long[]{0x00300000000001C0L});
        public static final BitSet FOLLOW_rule__FLOAT__Group__1_in_rule__FLOAT__Group__011520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Alternatives_0_in_rule__FLOAT__Group__0__Impl11547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Group__1__Impl_in_rule__FLOAT__Group__111578 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_rule__FLOAT__Group__2_in_rule__FLOAT__Group__111581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Alternatives_1_in_rule__FLOAT__Group__1__Impl11608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Group__2__Impl_in_rule__FLOAT__Group__211638 = new BitSet(new long[]{0x0000000000000140L});
        public static final BitSet FOLLOW_rule__FLOAT__Group__3_in_rule__FLOAT__Group__211641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_rule__FLOAT__Group__2__Impl11670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Group__3__Impl_in_rule__FLOAT__Group__311702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Alternatives_3_in_rule__FLOAT__Group__3__Impl11731 = new BitSet(new long[]{0x0000000000000142L});
        public static final BitSet FOLLOW_rule__FLOAT__Alternatives_3_in_rule__FLOAT__Group__3__Impl11743 = new BitSet(new long[]{0x0000000000000142L});
        public static final BitSet FOLLOW_rule__FLOAT__Group_1_1__0__Impl_in_rule__FLOAT__Group_1_1__011784 = new BitSet(new long[]{0x0000000000000140L});
        public static final BitSet FOLLOW_rule__FLOAT__Group_1_1__1_in_rule__FLOAT__Group_1_1__011787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NON_ZERO_INT_in_rule__FLOAT__Group_1_1__0__Impl11814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Group_1_1__1__Impl_in_rule__FLOAT__Group_1_1__111843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__FLOAT__Alternatives_1_1_1_in_rule__FLOAT__Group_1_1__1__Impl11870 = new BitSet(new long[]{0x0000000000000142L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilFile__OilVersionAssignment_1_211910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilImplementation_in_rule__OilFile__ImplementationAssignment_211941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilApplication_in_rule__OilFile__ApplicationAssignment_311972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__OilImplementation__NameAssignment_112003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObjectImpl_in_rule__OilImplementation__OilObjectsAssignment_312034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectType_in_rule__OilObjectImpl__TypeAssignment_012065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterType_in_rule__OilObjectImpl__ParametersAssignment_212096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilObjectImpl__DescriptionAssignment_4_112127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__OilApplication__NameAssignment_112158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOilObject_in_rule__OilApplication__OilObjectsAssignment_312189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilApplication__DescriptionAssignment_5_112220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericNumber_in_rule__ValueList__ValuesAssignment_112251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericNumber_in_rule__ValueList__ValuesAssignment_2_112282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericNumber_in_rule__Range__MinAssignment_112313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericNumber_in_rule__Range__MaxAssignment_312344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVType_in_rule__ValueType__TypeAssignment_112375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_rule__ValueType__WithAutoAssignment_212411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValidValues_in_rule__ValueType__ValidValuesAssignment_3_112450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__ValueType__NameAssignment_412481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_rule__ValueType__MultiValueAssignment_512517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_rule__ValueType__DefaultAutoAssignment_6_1_012561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ValueType__DefaultValueAlternatives_6_1_1_0_in_rule__ValueType__DefaultValueAssignment_6_1_112600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ValueType__DescriptionAssignment_7_112633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEType_in_rule__VariantType__TypeAssignment_112664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_rule__VariantType__WithAutoAssignment_212700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_3_1_012739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumeratorType_in_rule__VariantType__ValuesAssignment_3_1_1_112770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__VariantType__NameAssignment_412801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_rule__VariantType__MultiValueAssignment_512837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_rule__VariantType__DefaultAutoAssignment_6_1_012881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__VariantType__DefaultValueAssignment_6_1_112920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__VariantType__DescriptionAssignment_7_112951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__EnumeratorType__NameAssignment_112982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterType_in_rule__EnumeratorType__ParametersAssignment_2_113013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EnumeratorType__DescriptionAssignment_3_113044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectTypeRef_in_rule__ReferenceType__TypeAssignment_113075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__ReferenceType__NameAssignment_213106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_rule__ReferenceType__MultiValueAssignment_313142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_rule__ReferenceType__DefaultAutoAssignment_4_1_013186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceType__DefaultValueAssignment_4_1_113225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ReferenceType__DescriptionAssignment_5_113256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectType_in_rule__OilObject__TypeAssignment_013287 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__OilObject__NameAssignment_113318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_rule__OilObject__ParametersAssignment_2_113349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__OilObject__DescriptionAssignment_3_113380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__Parameter__TypeAssignment_113415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_rule__Parameter__AutoAssignment_3_013455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGenericValue_in_rule__Parameter__ValueAssignment_3_113494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecialId_in_rule__Parameter__ValueRefAssignment_3_213529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_rule__Parameter__ParametersAssignment_4_113564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Parameter__DescriptionAssignment_5_113595 = new BitSet(new long[]{0x0000000000000002L});
    }


}