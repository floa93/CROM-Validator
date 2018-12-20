package org.rosi.crom.validation.mapping.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.rosi.crom.validation.mapping.services.FeatureMappingGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFeatureMappingParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'universal'", "'feature'", "'invariant'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalFeatureMappingParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFeatureMappingParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFeatureMappingParser.tokenNames; }
    public String getGrammarFileName() { return "InternalFeatureMapping.g"; }


    	private FeatureMappingGrammarAccess grammarAccess;

    	public void setGrammarAccess(FeatureMappingGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleModel"
    // InternalFeatureMapping.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalFeatureMapping.g:54:1: ( ruleModel EOF )
            // InternalFeatureMapping.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalFeatureMapping.g:62:1: ruleModel : ( ( rule__Model__ElementsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:66:2: ( ( ( rule__Model__ElementsAssignment )* ) )
            // InternalFeatureMapping.g:67:2: ( ( rule__Model__ElementsAssignment )* )
            {
            // InternalFeatureMapping.g:67:2: ( ( rule__Model__ElementsAssignment )* )
            // InternalFeatureMapping.g:68:3: ( rule__Model__ElementsAssignment )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment()); 
            // InternalFeatureMapping.g:69:3: ( rule__Model__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=12)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalFeatureMapping.g:69:4: rule__Model__ElementsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Model__ElementsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getElementsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleUniversal"
    // InternalFeatureMapping.g:78:1: entryRuleUniversal : ruleUniversal EOF ;
    public final void entryRuleUniversal() throws RecognitionException {
        try {
            // InternalFeatureMapping.g:79:1: ( ruleUniversal EOF )
            // InternalFeatureMapping.g:80:1: ruleUniversal EOF
            {
             before(grammarAccess.getUniversalRule()); 
            pushFollow(FOLLOW_1);
            ruleUniversal();

            state._fsp--;

             after(grammarAccess.getUniversalRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleUniversal"


    // $ANTLR start "ruleUniversal"
    // InternalFeatureMapping.g:87:1: ruleUniversal : ( ( rule__Universal__Group__0 ) ) ;
    public final void ruleUniversal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:91:2: ( ( ( rule__Universal__Group__0 ) ) )
            // InternalFeatureMapping.g:92:2: ( ( rule__Universal__Group__0 ) )
            {
            // InternalFeatureMapping.g:92:2: ( ( rule__Universal__Group__0 ) )
            // InternalFeatureMapping.g:93:3: ( rule__Universal__Group__0 )
            {
             before(grammarAccess.getUniversalAccess().getGroup()); 
            // InternalFeatureMapping.g:94:3: ( rule__Universal__Group__0 )
            // InternalFeatureMapping.g:94:4: rule__Universal__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Universal__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUniversalAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUniversal"


    // $ANTLR start "entryRuleFeature"
    // InternalFeatureMapping.g:103:1: entryRuleFeature : ruleFeature EOF ;
    public final void entryRuleFeature() throws RecognitionException {
        try {
            // InternalFeatureMapping.g:104:1: ( ruleFeature EOF )
            // InternalFeatureMapping.g:105:1: ruleFeature EOF
            {
             before(grammarAccess.getFeatureRule()); 
            pushFollow(FOLLOW_1);
            ruleFeature();

            state._fsp--;

             after(grammarAccess.getFeatureRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFeature"


    // $ANTLR start "ruleFeature"
    // InternalFeatureMapping.g:112:1: ruleFeature : ( ( rule__Feature__Group__0 ) ) ;
    public final void ruleFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:116:2: ( ( ( rule__Feature__Group__0 ) ) )
            // InternalFeatureMapping.g:117:2: ( ( rule__Feature__Group__0 ) )
            {
            // InternalFeatureMapping.g:117:2: ( ( rule__Feature__Group__0 ) )
            // InternalFeatureMapping.g:118:3: ( rule__Feature__Group__0 )
            {
             before(grammarAccess.getFeatureAccess().getGroup()); 
            // InternalFeatureMapping.g:119:3: ( rule__Feature__Group__0 )
            // InternalFeatureMapping.g:119:4: rule__Feature__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Feature__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFeatureAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFeature"


    // $ANTLR start "entryRuleInvariant"
    // InternalFeatureMapping.g:128:1: entryRuleInvariant : ruleInvariant EOF ;
    public final void entryRuleInvariant() throws RecognitionException {
        try {
            // InternalFeatureMapping.g:129:1: ( ruleInvariant EOF )
            // InternalFeatureMapping.g:130:1: ruleInvariant EOF
            {
             before(grammarAccess.getInvariantRule()); 
            pushFollow(FOLLOW_1);
            ruleInvariant();

            state._fsp--;

             after(grammarAccess.getInvariantRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleInvariant"


    // $ANTLR start "ruleInvariant"
    // InternalFeatureMapping.g:137:1: ruleInvariant : ( ( rule__Invariant__Group__0 ) ) ;
    public final void ruleInvariant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:141:2: ( ( ( rule__Invariant__Group__0 ) ) )
            // InternalFeatureMapping.g:142:2: ( ( rule__Invariant__Group__0 ) )
            {
            // InternalFeatureMapping.g:142:2: ( ( rule__Invariant__Group__0 ) )
            // InternalFeatureMapping.g:143:3: ( rule__Invariant__Group__0 )
            {
             before(grammarAccess.getInvariantAccess().getGroup()); 
            // InternalFeatureMapping.g:144:3: ( rule__Invariant__Group__0 )
            // InternalFeatureMapping.g:144:4: rule__Invariant__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Invariant__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInvariantAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInvariant"


    // $ANTLR start "rule__Model__ElementsAlternatives_0"
    // InternalFeatureMapping.g:152:1: rule__Model__ElementsAlternatives_0 : ( ( ruleUniversal ) | ( ruleFeature ) );
    public final void rule__Model__ElementsAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:156:1: ( ( ruleUniversal ) | ( ruleFeature ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalFeatureMapping.g:157:2: ( ruleUniversal )
                    {
                    // InternalFeatureMapping.g:157:2: ( ruleUniversal )
                    // InternalFeatureMapping.g:158:3: ruleUniversal
                    {
                     before(grammarAccess.getModelAccess().getElementsUniversalParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleUniversal();

                    state._fsp--;

                     after(grammarAccess.getModelAccess().getElementsUniversalParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFeatureMapping.g:163:2: ( ruleFeature )
                    {
                    // InternalFeatureMapping.g:163:2: ( ruleFeature )
                    // InternalFeatureMapping.g:164:3: ruleFeature
                    {
                     before(grammarAccess.getModelAccess().getElementsFeatureParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleFeature();

                    state._fsp--;

                     after(grammarAccess.getModelAccess().getElementsFeatureParserRuleCall_0_1()); 

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
    // $ANTLR end "rule__Model__ElementsAlternatives_0"


    // $ANTLR start "rule__Universal__Group__0"
    // InternalFeatureMapping.g:173:1: rule__Universal__Group__0 : rule__Universal__Group__0__Impl rule__Universal__Group__1 ;
    public final void rule__Universal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:177:1: ( rule__Universal__Group__0__Impl rule__Universal__Group__1 )
            // InternalFeatureMapping.g:178:2: rule__Universal__Group__0__Impl rule__Universal__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Universal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Universal__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Universal__Group__0"


    // $ANTLR start "rule__Universal__Group__0__Impl"
    // InternalFeatureMapping.g:185:1: rule__Universal__Group__0__Impl : ( 'universal' ) ;
    public final void rule__Universal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:189:1: ( ( 'universal' ) )
            // InternalFeatureMapping.g:190:1: ( 'universal' )
            {
            // InternalFeatureMapping.g:190:1: ( 'universal' )
            // InternalFeatureMapping.g:191:2: 'universal'
            {
             before(grammarAccess.getUniversalAccess().getUniversalKeyword_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getUniversalAccess().getUniversalKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Universal__Group__0__Impl"


    // $ANTLR start "rule__Universal__Group__1"
    // InternalFeatureMapping.g:200:1: rule__Universal__Group__1 : rule__Universal__Group__1__Impl ;
    public final void rule__Universal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:204:1: ( rule__Universal__Group__1__Impl )
            // InternalFeatureMapping.g:205:2: rule__Universal__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Universal__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Universal__Group__1"


    // $ANTLR start "rule__Universal__Group__1__Impl"
    // InternalFeatureMapping.g:211:1: rule__Universal__Group__1__Impl : ( ( ( rule__Universal__ElementsAssignment_1 ) ) ( ( rule__Universal__ElementsAssignment_1 )* ) ) ;
    public final void rule__Universal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:215:1: ( ( ( ( rule__Universal__ElementsAssignment_1 ) ) ( ( rule__Universal__ElementsAssignment_1 )* ) ) )
            // InternalFeatureMapping.g:216:1: ( ( ( rule__Universal__ElementsAssignment_1 ) ) ( ( rule__Universal__ElementsAssignment_1 )* ) )
            {
            // InternalFeatureMapping.g:216:1: ( ( ( rule__Universal__ElementsAssignment_1 ) ) ( ( rule__Universal__ElementsAssignment_1 )* ) )
            // InternalFeatureMapping.g:217:2: ( ( rule__Universal__ElementsAssignment_1 ) ) ( ( rule__Universal__ElementsAssignment_1 )* )
            {
            // InternalFeatureMapping.g:217:2: ( ( rule__Universal__ElementsAssignment_1 ) )
            // InternalFeatureMapping.g:218:3: ( rule__Universal__ElementsAssignment_1 )
            {
             before(grammarAccess.getUniversalAccess().getElementsAssignment_1()); 
            // InternalFeatureMapping.g:219:3: ( rule__Universal__ElementsAssignment_1 )
            // InternalFeatureMapping.g:219:4: rule__Universal__ElementsAssignment_1
            {
            pushFollow(FOLLOW_5);
            rule__Universal__ElementsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getUniversalAccess().getElementsAssignment_1()); 

            }

            // InternalFeatureMapping.g:222:2: ( ( rule__Universal__ElementsAssignment_1 )* )
            // InternalFeatureMapping.g:223:3: ( rule__Universal__ElementsAssignment_1 )*
            {
             before(grammarAccess.getUniversalAccess().getElementsAssignment_1()); 
            // InternalFeatureMapping.g:224:3: ( rule__Universal__ElementsAssignment_1 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalFeatureMapping.g:224:4: rule__Universal__ElementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Universal__ElementsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getUniversalAccess().getElementsAssignment_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Universal__Group__1__Impl"


    // $ANTLR start "rule__Feature__Group__0"
    // InternalFeatureMapping.g:234:1: rule__Feature__Group__0 : rule__Feature__Group__0__Impl rule__Feature__Group__1 ;
    public final void rule__Feature__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:238:1: ( rule__Feature__Group__0__Impl rule__Feature__Group__1 )
            // InternalFeatureMapping.g:239:2: rule__Feature__Group__0__Impl rule__Feature__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Feature__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Feature__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Feature__Group__0"


    // $ANTLR start "rule__Feature__Group__0__Impl"
    // InternalFeatureMapping.g:246:1: rule__Feature__Group__0__Impl : ( 'feature' ) ;
    public final void rule__Feature__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:250:1: ( ( 'feature' ) )
            // InternalFeatureMapping.g:251:1: ( 'feature' )
            {
            // InternalFeatureMapping.g:251:1: ( 'feature' )
            // InternalFeatureMapping.g:252:2: 'feature'
            {
             before(grammarAccess.getFeatureAccess().getFeatureKeyword_0()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getFeatureAccess().getFeatureKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Feature__Group__0__Impl"


    // $ANTLR start "rule__Feature__Group__1"
    // InternalFeatureMapping.g:261:1: rule__Feature__Group__1 : rule__Feature__Group__1__Impl rule__Feature__Group__2 ;
    public final void rule__Feature__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:265:1: ( rule__Feature__Group__1__Impl rule__Feature__Group__2 )
            // InternalFeatureMapping.g:266:2: rule__Feature__Group__1__Impl rule__Feature__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Feature__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Feature__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Feature__Group__1"


    // $ANTLR start "rule__Feature__Group__1__Impl"
    // InternalFeatureMapping.g:273:1: rule__Feature__Group__1__Impl : ( ( rule__Feature__NameAssignment_1 ) ) ;
    public final void rule__Feature__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:277:1: ( ( ( rule__Feature__NameAssignment_1 ) ) )
            // InternalFeatureMapping.g:278:1: ( ( rule__Feature__NameAssignment_1 ) )
            {
            // InternalFeatureMapping.g:278:1: ( ( rule__Feature__NameAssignment_1 ) )
            // InternalFeatureMapping.g:279:2: ( rule__Feature__NameAssignment_1 )
            {
             before(grammarAccess.getFeatureAccess().getNameAssignment_1()); 
            // InternalFeatureMapping.g:280:2: ( rule__Feature__NameAssignment_1 )
            // InternalFeatureMapping.g:280:3: rule__Feature__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Feature__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFeatureAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Feature__Group__1__Impl"


    // $ANTLR start "rule__Feature__Group__2"
    // InternalFeatureMapping.g:288:1: rule__Feature__Group__2 : rule__Feature__Group__2__Impl ;
    public final void rule__Feature__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:292:1: ( rule__Feature__Group__2__Impl )
            // InternalFeatureMapping.g:293:2: rule__Feature__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Feature__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Feature__Group__2"


    // $ANTLR start "rule__Feature__Group__2__Impl"
    // InternalFeatureMapping.g:299:1: rule__Feature__Group__2__Impl : ( ( ( rule__Feature__ElementsAssignment_2 ) ) ( ( rule__Feature__ElementsAssignment_2 )* ) ) ;
    public final void rule__Feature__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:303:1: ( ( ( ( rule__Feature__ElementsAssignment_2 ) ) ( ( rule__Feature__ElementsAssignment_2 )* ) ) )
            // InternalFeatureMapping.g:304:1: ( ( ( rule__Feature__ElementsAssignment_2 ) ) ( ( rule__Feature__ElementsAssignment_2 )* ) )
            {
            // InternalFeatureMapping.g:304:1: ( ( ( rule__Feature__ElementsAssignment_2 ) ) ( ( rule__Feature__ElementsAssignment_2 )* ) )
            // InternalFeatureMapping.g:305:2: ( ( rule__Feature__ElementsAssignment_2 ) ) ( ( rule__Feature__ElementsAssignment_2 )* )
            {
            // InternalFeatureMapping.g:305:2: ( ( rule__Feature__ElementsAssignment_2 ) )
            // InternalFeatureMapping.g:306:3: ( rule__Feature__ElementsAssignment_2 )
            {
             before(grammarAccess.getFeatureAccess().getElementsAssignment_2()); 
            // InternalFeatureMapping.g:307:3: ( rule__Feature__ElementsAssignment_2 )
            // InternalFeatureMapping.g:307:4: rule__Feature__ElementsAssignment_2
            {
            pushFollow(FOLLOW_5);
            rule__Feature__ElementsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFeatureAccess().getElementsAssignment_2()); 

            }

            // InternalFeatureMapping.g:310:2: ( ( rule__Feature__ElementsAssignment_2 )* )
            // InternalFeatureMapping.g:311:3: ( rule__Feature__ElementsAssignment_2 )*
            {
             before(grammarAccess.getFeatureAccess().getElementsAssignment_2()); 
            // InternalFeatureMapping.g:312:3: ( rule__Feature__ElementsAssignment_2 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalFeatureMapping.g:312:4: rule__Feature__ElementsAssignment_2
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Feature__ElementsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getFeatureAccess().getElementsAssignment_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Feature__Group__2__Impl"


    // $ANTLR start "rule__Invariant__Group__0"
    // InternalFeatureMapping.g:322:1: rule__Invariant__Group__0 : rule__Invariant__Group__0__Impl rule__Invariant__Group__1 ;
    public final void rule__Invariant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:326:1: ( rule__Invariant__Group__0__Impl rule__Invariant__Group__1 )
            // InternalFeatureMapping.g:327:2: rule__Invariant__Group__0__Impl rule__Invariant__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Invariant__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Invariant__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Invariant__Group__0"


    // $ANTLR start "rule__Invariant__Group__0__Impl"
    // InternalFeatureMapping.g:334:1: rule__Invariant__Group__0__Impl : ( 'invariant' ) ;
    public final void rule__Invariant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:338:1: ( ( 'invariant' ) )
            // InternalFeatureMapping.g:339:1: ( 'invariant' )
            {
            // InternalFeatureMapping.g:339:1: ( 'invariant' )
            // InternalFeatureMapping.g:340:2: 'invariant'
            {
             before(grammarAccess.getInvariantAccess().getInvariantKeyword_0()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getInvariantAccess().getInvariantKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Invariant__Group__0__Impl"


    // $ANTLR start "rule__Invariant__Group__1"
    // InternalFeatureMapping.g:349:1: rule__Invariant__Group__1 : rule__Invariant__Group__1__Impl ;
    public final void rule__Invariant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:353:1: ( rule__Invariant__Group__1__Impl )
            // InternalFeatureMapping.g:354:2: rule__Invariant__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Invariant__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Invariant__Group__1"


    // $ANTLR start "rule__Invariant__Group__1__Impl"
    // InternalFeatureMapping.g:360:1: rule__Invariant__Group__1__Impl : ( ( rule__Invariant__NameAssignment_1 ) ) ;
    public final void rule__Invariant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:364:1: ( ( ( rule__Invariant__NameAssignment_1 ) ) )
            // InternalFeatureMapping.g:365:1: ( ( rule__Invariant__NameAssignment_1 ) )
            {
            // InternalFeatureMapping.g:365:1: ( ( rule__Invariant__NameAssignment_1 ) )
            // InternalFeatureMapping.g:366:2: ( rule__Invariant__NameAssignment_1 )
            {
             before(grammarAccess.getInvariantAccess().getNameAssignment_1()); 
            // InternalFeatureMapping.g:367:2: ( rule__Invariant__NameAssignment_1 )
            // InternalFeatureMapping.g:367:3: rule__Invariant__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Invariant__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getInvariantAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Invariant__Group__1__Impl"


    // $ANTLR start "rule__Model__ElementsAssignment"
    // InternalFeatureMapping.g:376:1: rule__Model__ElementsAssignment : ( ( rule__Model__ElementsAlternatives_0 ) ) ;
    public final void rule__Model__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:380:1: ( ( ( rule__Model__ElementsAlternatives_0 ) ) )
            // InternalFeatureMapping.g:381:2: ( ( rule__Model__ElementsAlternatives_0 ) )
            {
            // InternalFeatureMapping.g:381:2: ( ( rule__Model__ElementsAlternatives_0 ) )
            // InternalFeatureMapping.g:382:3: ( rule__Model__ElementsAlternatives_0 )
            {
             before(grammarAccess.getModelAccess().getElementsAlternatives_0()); 
            // InternalFeatureMapping.g:383:3: ( rule__Model__ElementsAlternatives_0 )
            // InternalFeatureMapping.g:383:4: rule__Model__ElementsAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__Model__ElementsAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getElementsAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ElementsAssignment"


    // $ANTLR start "rule__Universal__ElementsAssignment_1"
    // InternalFeatureMapping.g:391:1: rule__Universal__ElementsAssignment_1 : ( ruleInvariant ) ;
    public final void rule__Universal__ElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:395:1: ( ( ruleInvariant ) )
            // InternalFeatureMapping.g:396:2: ( ruleInvariant )
            {
            // InternalFeatureMapping.g:396:2: ( ruleInvariant )
            // InternalFeatureMapping.g:397:3: ruleInvariant
            {
             before(grammarAccess.getUniversalAccess().getElementsInvariantParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleInvariant();

            state._fsp--;

             after(grammarAccess.getUniversalAccess().getElementsInvariantParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Universal__ElementsAssignment_1"


    // $ANTLR start "rule__Feature__NameAssignment_1"
    // InternalFeatureMapping.g:406:1: rule__Feature__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Feature__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:410:1: ( ( RULE_ID ) )
            // InternalFeatureMapping.g:411:2: ( RULE_ID )
            {
            // InternalFeatureMapping.g:411:2: ( RULE_ID )
            // InternalFeatureMapping.g:412:3: RULE_ID
            {
             before(grammarAccess.getFeatureAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFeatureAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Feature__NameAssignment_1"


    // $ANTLR start "rule__Feature__ElementsAssignment_2"
    // InternalFeatureMapping.g:421:1: rule__Feature__ElementsAssignment_2 : ( ruleInvariant ) ;
    public final void rule__Feature__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:425:1: ( ( ruleInvariant ) )
            // InternalFeatureMapping.g:426:2: ( ruleInvariant )
            {
            // InternalFeatureMapping.g:426:2: ( ruleInvariant )
            // InternalFeatureMapping.g:427:3: ruleInvariant
            {
             before(grammarAccess.getFeatureAccess().getElementsInvariantParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleInvariant();

            state._fsp--;

             after(grammarAccess.getFeatureAccess().getElementsInvariantParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Feature__ElementsAssignment_2"


    // $ANTLR start "rule__Invariant__NameAssignment_1"
    // InternalFeatureMapping.g:436:1: rule__Invariant__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Invariant__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFeatureMapping.g:440:1: ( ( RULE_ID ) )
            // InternalFeatureMapping.g:441:2: ( RULE_ID )
            {
            // InternalFeatureMapping.g:441:2: ( RULE_ID )
            // InternalFeatureMapping.g:442:3: RULE_ID
            {
             before(grammarAccess.getInvariantAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getInvariantAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Invariant__NameAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});

}