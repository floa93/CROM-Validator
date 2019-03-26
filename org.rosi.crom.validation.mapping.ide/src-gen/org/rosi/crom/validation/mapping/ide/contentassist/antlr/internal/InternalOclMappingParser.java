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
import org.rosi.crom.validation.mapping.services.OclMappingGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOclMappingParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'feature'", "'invariant'", "'or'", "'and'", "'not'", "'('", "')'", "'true'", "'false'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalOclMappingParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOclMappingParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOclMappingParser.tokenNames; }
    public String getGrammarFileName() { return "InternalOclMapping.g"; }


    	private OclMappingGrammarAccess grammarAccess;

    	public void setGrammarAccess(OclMappingGrammarAccess grammarAccess) {
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
    // InternalOclMapping.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalOclMapping.g:54:1: ( ruleModel EOF )
            // InternalOclMapping.g:55:1: ruleModel EOF
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
    // InternalOclMapping.g:62:1: ruleModel : ( ( rule__Model__ElementsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:66:2: ( ( ( rule__Model__ElementsAssignment )* ) )
            // InternalOclMapping.g:67:2: ( ( rule__Model__ElementsAssignment )* )
            {
            // InternalOclMapping.g:67:2: ( ( rule__Model__ElementsAssignment )* )
            // InternalOclMapping.g:68:3: ( rule__Model__ElementsAssignment )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment()); 
            // InternalOclMapping.g:69:3: ( rule__Model__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalOclMapping.g:69:4: rule__Model__ElementsAssignment
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


    // $ANTLR start "entryRuleFeature"
    // InternalOclMapping.g:78:1: entryRuleFeature : ruleFeature EOF ;
    public final void entryRuleFeature() throws RecognitionException {
        try {
            // InternalOclMapping.g:79:1: ( ruleFeature EOF )
            // InternalOclMapping.g:80:1: ruleFeature EOF
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
    // InternalOclMapping.g:87:1: ruleFeature : ( ( rule__Feature__Group__0 ) ) ;
    public final void ruleFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:91:2: ( ( ( rule__Feature__Group__0 ) ) )
            // InternalOclMapping.g:92:2: ( ( rule__Feature__Group__0 ) )
            {
            // InternalOclMapping.g:92:2: ( ( rule__Feature__Group__0 ) )
            // InternalOclMapping.g:93:3: ( rule__Feature__Group__0 )
            {
             before(grammarAccess.getFeatureAccess().getGroup()); 
            // InternalOclMapping.g:94:3: ( rule__Feature__Group__0 )
            // InternalOclMapping.g:94:4: rule__Feature__Group__0
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
    // InternalOclMapping.g:103:1: entryRuleInvariant : ruleInvariant EOF ;
    public final void entryRuleInvariant() throws RecognitionException {
        try {
            // InternalOclMapping.g:104:1: ( ruleInvariant EOF )
            // InternalOclMapping.g:105:1: ruleInvariant EOF
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
    // InternalOclMapping.g:112:1: ruleInvariant : ( ( rule__Invariant__Group__0 ) ) ;
    public final void ruleInvariant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:116:2: ( ( ( rule__Invariant__Group__0 ) ) )
            // InternalOclMapping.g:117:2: ( ( rule__Invariant__Group__0 ) )
            {
            // InternalOclMapping.g:117:2: ( ( rule__Invariant__Group__0 ) )
            // InternalOclMapping.g:118:3: ( rule__Invariant__Group__0 )
            {
             before(grammarAccess.getInvariantAccess().getGroup()); 
            // InternalOclMapping.g:119:3: ( rule__Invariant__Group__0 )
            // InternalOclMapping.g:119:4: rule__Invariant__Group__0
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


    // $ANTLR start "entryRuleExpression"
    // InternalOclMapping.g:128:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalOclMapping.g:129:1: ( ruleExpression EOF )
            // InternalOclMapping.g:130:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalOclMapping.g:137:1: ruleExpression : ( ruleOrExpression ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:141:2: ( ( ruleOrExpression ) )
            // InternalOclMapping.g:142:2: ( ruleOrExpression )
            {
            // InternalOclMapping.g:142:2: ( ruleOrExpression )
            // InternalOclMapping.g:143:3: ruleOrExpression
            {
             before(grammarAccess.getExpressionAccess().getOrExpressionParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleOrExpression();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getOrExpressionParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleOrExpression"
    // InternalOclMapping.g:153:1: entryRuleOrExpression : ruleOrExpression EOF ;
    public final void entryRuleOrExpression() throws RecognitionException {
        try {
            // InternalOclMapping.g:154:1: ( ruleOrExpression EOF )
            // InternalOclMapping.g:155:1: ruleOrExpression EOF
            {
             before(grammarAccess.getOrExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleOrExpression();

            state._fsp--;

             after(grammarAccess.getOrExpressionRule()); 
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
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalOclMapping.g:162:1: ruleOrExpression : ( ( rule__OrExpression__Group__0 ) ) ;
    public final void ruleOrExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:166:2: ( ( ( rule__OrExpression__Group__0 ) ) )
            // InternalOclMapping.g:167:2: ( ( rule__OrExpression__Group__0 ) )
            {
            // InternalOclMapping.g:167:2: ( ( rule__OrExpression__Group__0 ) )
            // InternalOclMapping.g:168:3: ( rule__OrExpression__Group__0 )
            {
             before(grammarAccess.getOrExpressionAccess().getGroup()); 
            // InternalOclMapping.g:169:3: ( rule__OrExpression__Group__0 )
            // InternalOclMapping.g:169:4: rule__OrExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalOclMapping.g:178:1: entryRuleAndExpression : ruleAndExpression EOF ;
    public final void entryRuleAndExpression() throws RecognitionException {
        try {
            // InternalOclMapping.g:179:1: ( ruleAndExpression EOF )
            // InternalOclMapping.g:180:1: ruleAndExpression EOF
            {
             before(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleAndExpression();

            state._fsp--;

             after(grammarAccess.getAndExpressionRule()); 
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
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalOclMapping.g:187:1: ruleAndExpression : ( ( rule__AndExpression__Group__0 ) ) ;
    public final void ruleAndExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:191:2: ( ( ( rule__AndExpression__Group__0 ) ) )
            // InternalOclMapping.g:192:2: ( ( rule__AndExpression__Group__0 ) )
            {
            // InternalOclMapping.g:192:2: ( ( rule__AndExpression__Group__0 ) )
            // InternalOclMapping.g:193:3: ( rule__AndExpression__Group__0 )
            {
             before(grammarAccess.getAndExpressionAccess().getGroup()); 
            // InternalOclMapping.g:194:3: ( rule__AndExpression__Group__0 )
            // InternalOclMapping.g:194:4: rule__AndExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAndExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleNotExpression"
    // InternalOclMapping.g:203:1: entryRuleNotExpression : ruleNotExpression EOF ;
    public final void entryRuleNotExpression() throws RecognitionException {
        try {
            // InternalOclMapping.g:204:1: ( ruleNotExpression EOF )
            // InternalOclMapping.g:205:1: ruleNotExpression EOF
            {
             before(grammarAccess.getNotExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleNotExpression();

            state._fsp--;

             after(grammarAccess.getNotExpressionRule()); 
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
    // $ANTLR end "entryRuleNotExpression"


    // $ANTLR start "ruleNotExpression"
    // InternalOclMapping.g:212:1: ruleNotExpression : ( ( rule__NotExpression__Alternatives ) ) ;
    public final void ruleNotExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:216:2: ( ( ( rule__NotExpression__Alternatives ) ) )
            // InternalOclMapping.g:217:2: ( ( rule__NotExpression__Alternatives ) )
            {
            // InternalOclMapping.g:217:2: ( ( rule__NotExpression__Alternatives ) )
            // InternalOclMapping.g:218:3: ( rule__NotExpression__Alternatives )
            {
             before(grammarAccess.getNotExpressionAccess().getAlternatives()); 
            // InternalOclMapping.g:219:3: ( rule__NotExpression__Alternatives )
            // InternalOclMapping.g:219:4: rule__NotExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NotExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNotExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNotExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalOclMapping.g:228:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // InternalOclMapping.g:229:1: ( rulePrimaryExpression EOF )
            // InternalOclMapping.g:230:1: rulePrimaryExpression EOF
            {
             before(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            rulePrimaryExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionRule()); 
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
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalOclMapping.g:237:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Alternatives ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:241:2: ( ( ( rule__PrimaryExpression__Alternatives ) ) )
            // InternalOclMapping.g:242:2: ( ( rule__PrimaryExpression__Alternatives ) )
            {
            // InternalOclMapping.g:242:2: ( ( rule__PrimaryExpression__Alternatives ) )
            // InternalOclMapping.g:243:3: ( rule__PrimaryExpression__Alternatives )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            // InternalOclMapping.g:244:3: ( rule__PrimaryExpression__Alternatives )
            // InternalOclMapping.g:244:4: rule__PrimaryExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleLiteral"
    // InternalOclMapping.g:253:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // InternalOclMapping.g:254:1: ( ruleLiteral EOF )
            // InternalOclMapping.g:255:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalOclMapping.g:262:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:266:2: ( ( ( rule__Literal__Alternatives ) ) )
            // InternalOclMapping.g:267:2: ( ( rule__Literal__Alternatives ) )
            {
            // InternalOclMapping.g:267:2: ( ( rule__Literal__Alternatives ) )
            // InternalOclMapping.g:268:3: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // InternalOclMapping.g:269:3: ( rule__Literal__Alternatives )
            // InternalOclMapping.g:269:4: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Literal__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "rule__NotExpression__Alternatives"
    // InternalOclMapping.g:277:1: rule__NotExpression__Alternatives : ( ( ( rule__NotExpression__Group_0__0 ) ) | ( rulePrimaryExpression ) );
    public final void rule__NotExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:281:1: ( ( ( rule__NotExpression__Group_0__0 ) ) | ( rulePrimaryExpression ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==15) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID||LA2_0==16||(LA2_0>=18 && LA2_0<=19)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalOclMapping.g:282:2: ( ( rule__NotExpression__Group_0__0 ) )
                    {
                    // InternalOclMapping.g:282:2: ( ( rule__NotExpression__Group_0__0 ) )
                    // InternalOclMapping.g:283:3: ( rule__NotExpression__Group_0__0 )
                    {
                     before(grammarAccess.getNotExpressionAccess().getGroup_0()); 
                    // InternalOclMapping.g:284:3: ( rule__NotExpression__Group_0__0 )
                    // InternalOclMapping.g:284:4: rule__NotExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NotExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNotExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOclMapping.g:288:2: ( rulePrimaryExpression )
                    {
                    // InternalOclMapping.g:288:2: ( rulePrimaryExpression )
                    // InternalOclMapping.g:289:3: rulePrimaryExpression
                    {
                     before(grammarAccess.getNotExpressionAccess().getPrimaryExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    rulePrimaryExpression();

                    state._fsp--;

                     after(grammarAccess.getNotExpressionAccess().getPrimaryExpressionParserRuleCall_1()); 

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
    // $ANTLR end "rule__NotExpression__Alternatives"


    // $ANTLR start "rule__PrimaryExpression__Alternatives"
    // InternalOclMapping.g:298:1: rule__PrimaryExpression__Alternatives : ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ruleLiteral ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:302:1: ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ruleLiteral ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID||(LA3_0>=18 && LA3_0<=19)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalOclMapping.g:303:2: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    {
                    // InternalOclMapping.g:303:2: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    // InternalOclMapping.g:304:3: ( rule__PrimaryExpression__Group_0__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 
                    // InternalOclMapping.g:305:3: ( rule__PrimaryExpression__Group_0__0 )
                    // InternalOclMapping.g:305:4: rule__PrimaryExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimaryExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOclMapping.g:309:2: ( ruleLiteral )
                    {
                    // InternalOclMapping.g:309:2: ( ruleLiteral )
                    // InternalOclMapping.g:310:3: ruleLiteral
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_1()); 

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
    // $ANTLR end "rule__PrimaryExpression__Alternatives"


    // $ANTLR start "rule__Literal__Alternatives"
    // InternalOclMapping.g:319:1: rule__Literal__Alternatives : ( ( ( rule__Literal__Group_0__0 ) ) | ( ( rule__Literal__Group_1__0 ) ) | ( ( rule__Literal__Group_2__0 ) ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:323:1: ( ( ( rule__Literal__Group_0__0 ) ) | ( ( rule__Literal__Group_1__0 ) ) | ( ( rule__Literal__Group_2__0 ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt4=1;
                }
                break;
            case 19:
                {
                alt4=2;
                }
                break;
            case RULE_ID:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalOclMapping.g:324:2: ( ( rule__Literal__Group_0__0 ) )
                    {
                    // InternalOclMapping.g:324:2: ( ( rule__Literal__Group_0__0 ) )
                    // InternalOclMapping.g:325:3: ( rule__Literal__Group_0__0 )
                    {
                     before(grammarAccess.getLiteralAccess().getGroup_0()); 
                    // InternalOclMapping.g:326:3: ( rule__Literal__Group_0__0 )
                    // InternalOclMapping.g:326:4: rule__Literal__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Literal__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOclMapping.g:330:2: ( ( rule__Literal__Group_1__0 ) )
                    {
                    // InternalOclMapping.g:330:2: ( ( rule__Literal__Group_1__0 ) )
                    // InternalOclMapping.g:331:3: ( rule__Literal__Group_1__0 )
                    {
                     before(grammarAccess.getLiteralAccess().getGroup_1()); 
                    // InternalOclMapping.g:332:3: ( rule__Literal__Group_1__0 )
                    // InternalOclMapping.g:332:4: rule__Literal__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Literal__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOclMapping.g:336:2: ( ( rule__Literal__Group_2__0 ) )
                    {
                    // InternalOclMapping.g:336:2: ( ( rule__Literal__Group_2__0 ) )
                    // InternalOclMapping.g:337:3: ( rule__Literal__Group_2__0 )
                    {
                     before(grammarAccess.getLiteralAccess().getGroup_2()); 
                    // InternalOclMapping.g:338:3: ( rule__Literal__Group_2__0 )
                    // InternalOclMapping.g:338:4: rule__Literal__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Literal__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getGroup_2()); 

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
    // $ANTLR end "rule__Literal__Alternatives"


    // $ANTLR start "rule__Feature__Group__0"
    // InternalOclMapping.g:346:1: rule__Feature__Group__0 : rule__Feature__Group__0__Impl rule__Feature__Group__1 ;
    public final void rule__Feature__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:350:1: ( rule__Feature__Group__0__Impl rule__Feature__Group__1 )
            // InternalOclMapping.g:351:2: rule__Feature__Group__0__Impl rule__Feature__Group__1
            {
            pushFollow(FOLLOW_4);
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
    // InternalOclMapping.g:358:1: rule__Feature__Group__0__Impl : ( 'feature' ) ;
    public final void rule__Feature__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:362:1: ( ( 'feature' ) )
            // InternalOclMapping.g:363:1: ( 'feature' )
            {
            // InternalOclMapping.g:363:1: ( 'feature' )
            // InternalOclMapping.g:364:2: 'feature'
            {
             before(grammarAccess.getFeatureAccess().getFeatureKeyword_0()); 
            match(input,11,FOLLOW_2); 
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
    // InternalOclMapping.g:373:1: rule__Feature__Group__1 : rule__Feature__Group__1__Impl rule__Feature__Group__2 ;
    public final void rule__Feature__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:377:1: ( rule__Feature__Group__1__Impl rule__Feature__Group__2 )
            // InternalOclMapping.g:378:2: rule__Feature__Group__1__Impl rule__Feature__Group__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalOclMapping.g:385:1: rule__Feature__Group__1__Impl : ( ruleExpression ) ;
    public final void rule__Feature__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:389:1: ( ( ruleExpression ) )
            // InternalOclMapping.g:390:1: ( ruleExpression )
            {
            // InternalOclMapping.g:390:1: ( ruleExpression )
            // InternalOclMapping.g:391:2: ruleExpression
            {
             before(grammarAccess.getFeatureAccess().getExpressionParserRuleCall_1()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getFeatureAccess().getExpressionParserRuleCall_1()); 

            }


            }

        }
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
    // InternalOclMapping.g:400:1: rule__Feature__Group__2 : rule__Feature__Group__2__Impl ;
    public final void rule__Feature__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:404:1: ( rule__Feature__Group__2__Impl )
            // InternalOclMapping.g:405:2: rule__Feature__Group__2__Impl
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
    // InternalOclMapping.g:411:1: rule__Feature__Group__2__Impl : ( ( ( rule__Feature__ElementsAssignment_2 ) ) ( ( rule__Feature__ElementsAssignment_2 )* ) ) ;
    public final void rule__Feature__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:415:1: ( ( ( ( rule__Feature__ElementsAssignment_2 ) ) ( ( rule__Feature__ElementsAssignment_2 )* ) ) )
            // InternalOclMapping.g:416:1: ( ( ( rule__Feature__ElementsAssignment_2 ) ) ( ( rule__Feature__ElementsAssignment_2 )* ) )
            {
            // InternalOclMapping.g:416:1: ( ( ( rule__Feature__ElementsAssignment_2 ) ) ( ( rule__Feature__ElementsAssignment_2 )* ) )
            // InternalOclMapping.g:417:2: ( ( rule__Feature__ElementsAssignment_2 ) ) ( ( rule__Feature__ElementsAssignment_2 )* )
            {
            // InternalOclMapping.g:417:2: ( ( rule__Feature__ElementsAssignment_2 ) )
            // InternalOclMapping.g:418:3: ( rule__Feature__ElementsAssignment_2 )
            {
             before(grammarAccess.getFeatureAccess().getElementsAssignment_2()); 
            // InternalOclMapping.g:419:3: ( rule__Feature__ElementsAssignment_2 )
            // InternalOclMapping.g:419:4: rule__Feature__ElementsAssignment_2
            {
            pushFollow(FOLLOW_6);
            rule__Feature__ElementsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFeatureAccess().getElementsAssignment_2()); 

            }

            // InternalOclMapping.g:422:2: ( ( rule__Feature__ElementsAssignment_2 )* )
            // InternalOclMapping.g:423:3: ( rule__Feature__ElementsAssignment_2 )*
            {
             before(grammarAccess.getFeatureAccess().getElementsAssignment_2()); 
            // InternalOclMapping.g:424:3: ( rule__Feature__ElementsAssignment_2 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==12) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalOclMapping.g:424:4: rule__Feature__ElementsAssignment_2
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Feature__ElementsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // InternalOclMapping.g:434:1: rule__Invariant__Group__0 : rule__Invariant__Group__0__Impl rule__Invariant__Group__1 ;
    public final void rule__Invariant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:438:1: ( rule__Invariant__Group__0__Impl rule__Invariant__Group__1 )
            // InternalOclMapping.g:439:2: rule__Invariant__Group__0__Impl rule__Invariant__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalOclMapping.g:446:1: rule__Invariant__Group__0__Impl : ( 'invariant' ) ;
    public final void rule__Invariant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:450:1: ( ( 'invariant' ) )
            // InternalOclMapping.g:451:1: ( 'invariant' )
            {
            // InternalOclMapping.g:451:1: ( 'invariant' )
            // InternalOclMapping.g:452:2: 'invariant'
            {
             before(grammarAccess.getInvariantAccess().getInvariantKeyword_0()); 
            match(input,12,FOLLOW_2); 
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
    // InternalOclMapping.g:461:1: rule__Invariant__Group__1 : rule__Invariant__Group__1__Impl ;
    public final void rule__Invariant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:465:1: ( rule__Invariant__Group__1__Impl )
            // InternalOclMapping.g:466:2: rule__Invariant__Group__1__Impl
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
    // InternalOclMapping.g:472:1: rule__Invariant__Group__1__Impl : ( ( rule__Invariant__NameAssignment_1 ) ) ;
    public final void rule__Invariant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:476:1: ( ( ( rule__Invariant__NameAssignment_1 ) ) )
            // InternalOclMapping.g:477:1: ( ( rule__Invariant__NameAssignment_1 ) )
            {
            // InternalOclMapping.g:477:1: ( ( rule__Invariant__NameAssignment_1 ) )
            // InternalOclMapping.g:478:2: ( rule__Invariant__NameAssignment_1 )
            {
             before(grammarAccess.getInvariantAccess().getNameAssignment_1()); 
            // InternalOclMapping.g:479:2: ( rule__Invariant__NameAssignment_1 )
            // InternalOclMapping.g:479:3: rule__Invariant__NameAssignment_1
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


    // $ANTLR start "rule__OrExpression__Group__0"
    // InternalOclMapping.g:488:1: rule__OrExpression__Group__0 : rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1 ;
    public final void rule__OrExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:492:1: ( rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1 )
            // InternalOclMapping.g:493:2: rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__OrExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrExpression__Group__1();

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
    // $ANTLR end "rule__OrExpression__Group__0"


    // $ANTLR start "rule__OrExpression__Group__0__Impl"
    // InternalOclMapping.g:500:1: rule__OrExpression__Group__0__Impl : ( ruleAndExpression ) ;
    public final void rule__OrExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:504:1: ( ( ruleAndExpression ) )
            // InternalOclMapping.g:505:1: ( ruleAndExpression )
            {
            // InternalOclMapping.g:505:1: ( ruleAndExpression )
            // InternalOclMapping.g:506:2: ruleAndExpression
            {
             before(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAndExpression();

            state._fsp--;

             after(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group__0__Impl"


    // $ANTLR start "rule__OrExpression__Group__1"
    // InternalOclMapping.g:515:1: rule__OrExpression__Group__1 : rule__OrExpression__Group__1__Impl ;
    public final void rule__OrExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:519:1: ( rule__OrExpression__Group__1__Impl )
            // InternalOclMapping.g:520:2: rule__OrExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group__1__Impl();

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
    // $ANTLR end "rule__OrExpression__Group__1"


    // $ANTLR start "rule__OrExpression__Group__1__Impl"
    // InternalOclMapping.g:526:1: rule__OrExpression__Group__1__Impl : ( ( rule__OrExpression__Group_1__0 )* ) ;
    public final void rule__OrExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:530:1: ( ( ( rule__OrExpression__Group_1__0 )* ) )
            // InternalOclMapping.g:531:1: ( ( rule__OrExpression__Group_1__0 )* )
            {
            // InternalOclMapping.g:531:1: ( ( rule__OrExpression__Group_1__0 )* )
            // InternalOclMapping.g:532:2: ( rule__OrExpression__Group_1__0 )*
            {
             before(grammarAccess.getOrExpressionAccess().getGroup_1()); 
            // InternalOclMapping.g:533:2: ( rule__OrExpression__Group_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==13) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalOclMapping.g:533:3: rule__OrExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__OrExpression__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getOrExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group__1__Impl"


    // $ANTLR start "rule__OrExpression__Group_1__0"
    // InternalOclMapping.g:542:1: rule__OrExpression__Group_1__0 : rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1 ;
    public final void rule__OrExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:546:1: ( rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1 )
            // InternalOclMapping.g:547:2: rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1
            {
            pushFollow(FOLLOW_8);
            rule__OrExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrExpression__Group_1__1();

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
    // $ANTLR end "rule__OrExpression__Group_1__0"


    // $ANTLR start "rule__OrExpression__Group_1__0__Impl"
    // InternalOclMapping.g:554:1: rule__OrExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__OrExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:558:1: ( ( () ) )
            // InternalOclMapping.g:559:1: ( () )
            {
            // InternalOclMapping.g:559:1: ( () )
            // InternalOclMapping.g:560:2: ()
            {
             before(grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0()); 
            // InternalOclMapping.g:561:2: ()
            // InternalOclMapping.g:561:3: 
            {
            }

             after(grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__0__Impl"


    // $ANTLR start "rule__OrExpression__Group_1__1"
    // InternalOclMapping.g:569:1: rule__OrExpression__Group_1__1 : rule__OrExpression__Group_1__1__Impl rule__OrExpression__Group_1__2 ;
    public final void rule__OrExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:573:1: ( rule__OrExpression__Group_1__1__Impl rule__OrExpression__Group_1__2 )
            // InternalOclMapping.g:574:2: rule__OrExpression__Group_1__1__Impl rule__OrExpression__Group_1__2
            {
            pushFollow(FOLLOW_4);
            rule__OrExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrExpression__Group_1__2();

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
    // $ANTLR end "rule__OrExpression__Group_1__1"


    // $ANTLR start "rule__OrExpression__Group_1__1__Impl"
    // InternalOclMapping.g:581:1: rule__OrExpression__Group_1__1__Impl : ( 'or' ) ;
    public final void rule__OrExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:585:1: ( ( 'or' ) )
            // InternalOclMapping.g:586:1: ( 'or' )
            {
            // InternalOclMapping.g:586:1: ( 'or' )
            // InternalOclMapping.g:587:2: 'or'
            {
             before(grammarAccess.getOrExpressionAccess().getOrKeyword_1_1()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getOrExpressionAccess().getOrKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__1__Impl"


    // $ANTLR start "rule__OrExpression__Group_1__2"
    // InternalOclMapping.g:596:1: rule__OrExpression__Group_1__2 : rule__OrExpression__Group_1__2__Impl ;
    public final void rule__OrExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:600:1: ( rule__OrExpression__Group_1__2__Impl )
            // InternalOclMapping.g:601:2: rule__OrExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group_1__2__Impl();

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
    // $ANTLR end "rule__OrExpression__Group_1__2"


    // $ANTLR start "rule__OrExpression__Group_1__2__Impl"
    // InternalOclMapping.g:607:1: rule__OrExpression__Group_1__2__Impl : ( ( rule__OrExpression__RightAssignment_1_2 ) ) ;
    public final void rule__OrExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:611:1: ( ( ( rule__OrExpression__RightAssignment_1_2 ) ) )
            // InternalOclMapping.g:612:1: ( ( rule__OrExpression__RightAssignment_1_2 ) )
            {
            // InternalOclMapping.g:612:1: ( ( rule__OrExpression__RightAssignment_1_2 ) )
            // InternalOclMapping.g:613:2: ( rule__OrExpression__RightAssignment_1_2 )
            {
             before(grammarAccess.getOrExpressionAccess().getRightAssignment_1_2()); 
            // InternalOclMapping.g:614:2: ( rule__OrExpression__RightAssignment_1_2 )
            // InternalOclMapping.g:614:3: rule__OrExpression__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getOrExpressionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__2__Impl"


    // $ANTLR start "rule__AndExpression__Group__0"
    // InternalOclMapping.g:623:1: rule__AndExpression__Group__0 : rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1 ;
    public final void rule__AndExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:627:1: ( rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1 )
            // InternalOclMapping.g:628:2: rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__AndExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndExpression__Group__1();

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
    // $ANTLR end "rule__AndExpression__Group__0"


    // $ANTLR start "rule__AndExpression__Group__0__Impl"
    // InternalOclMapping.g:635:1: rule__AndExpression__Group__0__Impl : ( ruleNotExpression ) ;
    public final void rule__AndExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:639:1: ( ( ruleNotExpression ) )
            // InternalOclMapping.g:640:1: ( ruleNotExpression )
            {
            // InternalOclMapping.g:640:1: ( ruleNotExpression )
            // InternalOclMapping.g:641:2: ruleNotExpression
            {
             before(grammarAccess.getAndExpressionAccess().getNotExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleNotExpression();

            state._fsp--;

             after(grammarAccess.getAndExpressionAccess().getNotExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__0__Impl"


    // $ANTLR start "rule__AndExpression__Group__1"
    // InternalOclMapping.g:650:1: rule__AndExpression__Group__1 : rule__AndExpression__Group__1__Impl ;
    public final void rule__AndExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:654:1: ( rule__AndExpression__Group__1__Impl )
            // InternalOclMapping.g:655:2: rule__AndExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group__1__Impl();

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
    // $ANTLR end "rule__AndExpression__Group__1"


    // $ANTLR start "rule__AndExpression__Group__1__Impl"
    // InternalOclMapping.g:661:1: rule__AndExpression__Group__1__Impl : ( ( rule__AndExpression__Group_1__0 )* ) ;
    public final void rule__AndExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:665:1: ( ( ( rule__AndExpression__Group_1__0 )* ) )
            // InternalOclMapping.g:666:1: ( ( rule__AndExpression__Group_1__0 )* )
            {
            // InternalOclMapping.g:666:1: ( ( rule__AndExpression__Group_1__0 )* )
            // InternalOclMapping.g:667:2: ( rule__AndExpression__Group_1__0 )*
            {
             before(grammarAccess.getAndExpressionAccess().getGroup_1()); 
            // InternalOclMapping.g:668:2: ( rule__AndExpression__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==14) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalOclMapping.g:668:3: rule__AndExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__AndExpression__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getAndExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__1__Impl"


    // $ANTLR start "rule__AndExpression__Group_1__0"
    // InternalOclMapping.g:677:1: rule__AndExpression__Group_1__0 : rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1 ;
    public final void rule__AndExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:681:1: ( rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1 )
            // InternalOclMapping.g:682:2: rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1
            {
            pushFollow(FOLLOW_10);
            rule__AndExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndExpression__Group_1__1();

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
    // $ANTLR end "rule__AndExpression__Group_1__0"


    // $ANTLR start "rule__AndExpression__Group_1__0__Impl"
    // InternalOclMapping.g:689:1: rule__AndExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__AndExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:693:1: ( ( () ) )
            // InternalOclMapping.g:694:1: ( () )
            {
            // InternalOclMapping.g:694:1: ( () )
            // InternalOclMapping.g:695:2: ()
            {
             before(grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0()); 
            // InternalOclMapping.g:696:2: ()
            // InternalOclMapping.g:696:3: 
            {
            }

             after(grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__0__Impl"


    // $ANTLR start "rule__AndExpression__Group_1__1"
    // InternalOclMapping.g:704:1: rule__AndExpression__Group_1__1 : rule__AndExpression__Group_1__1__Impl rule__AndExpression__Group_1__2 ;
    public final void rule__AndExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:708:1: ( rule__AndExpression__Group_1__1__Impl rule__AndExpression__Group_1__2 )
            // InternalOclMapping.g:709:2: rule__AndExpression__Group_1__1__Impl rule__AndExpression__Group_1__2
            {
            pushFollow(FOLLOW_4);
            rule__AndExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndExpression__Group_1__2();

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
    // $ANTLR end "rule__AndExpression__Group_1__1"


    // $ANTLR start "rule__AndExpression__Group_1__1__Impl"
    // InternalOclMapping.g:716:1: rule__AndExpression__Group_1__1__Impl : ( 'and' ) ;
    public final void rule__AndExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:720:1: ( ( 'and' ) )
            // InternalOclMapping.g:721:1: ( 'and' )
            {
            // InternalOclMapping.g:721:1: ( 'and' )
            // InternalOclMapping.g:722:2: 'and'
            {
             before(grammarAccess.getAndExpressionAccess().getAndKeyword_1_1()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getAndExpressionAccess().getAndKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__1__Impl"


    // $ANTLR start "rule__AndExpression__Group_1__2"
    // InternalOclMapping.g:731:1: rule__AndExpression__Group_1__2 : rule__AndExpression__Group_1__2__Impl ;
    public final void rule__AndExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:735:1: ( rule__AndExpression__Group_1__2__Impl )
            // InternalOclMapping.g:736:2: rule__AndExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group_1__2__Impl();

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
    // $ANTLR end "rule__AndExpression__Group_1__2"


    // $ANTLR start "rule__AndExpression__Group_1__2__Impl"
    // InternalOclMapping.g:742:1: rule__AndExpression__Group_1__2__Impl : ( ( rule__AndExpression__RightAssignment_1_2 ) ) ;
    public final void rule__AndExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:746:1: ( ( ( rule__AndExpression__RightAssignment_1_2 ) ) )
            // InternalOclMapping.g:747:1: ( ( rule__AndExpression__RightAssignment_1_2 ) )
            {
            // InternalOclMapping.g:747:1: ( ( rule__AndExpression__RightAssignment_1_2 ) )
            // InternalOclMapping.g:748:2: ( rule__AndExpression__RightAssignment_1_2 )
            {
             before(grammarAccess.getAndExpressionAccess().getRightAssignment_1_2()); 
            // InternalOclMapping.g:749:2: ( rule__AndExpression__RightAssignment_1_2 )
            // InternalOclMapping.g:749:3: rule__AndExpression__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getAndExpressionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__2__Impl"


    // $ANTLR start "rule__NotExpression__Group_0__0"
    // InternalOclMapping.g:758:1: rule__NotExpression__Group_0__0 : rule__NotExpression__Group_0__0__Impl rule__NotExpression__Group_0__1 ;
    public final void rule__NotExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:762:1: ( rule__NotExpression__Group_0__0__Impl rule__NotExpression__Group_0__1 )
            // InternalOclMapping.g:763:2: rule__NotExpression__Group_0__0__Impl rule__NotExpression__Group_0__1
            {
            pushFollow(FOLLOW_12);
            rule__NotExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NotExpression__Group_0__1();

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
    // $ANTLR end "rule__NotExpression__Group_0__0"


    // $ANTLR start "rule__NotExpression__Group_0__0__Impl"
    // InternalOclMapping.g:770:1: rule__NotExpression__Group_0__0__Impl : ( () ) ;
    public final void rule__NotExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:774:1: ( ( () ) )
            // InternalOclMapping.g:775:1: ( () )
            {
            // InternalOclMapping.g:775:1: ( () )
            // InternalOclMapping.g:776:2: ()
            {
             before(grammarAccess.getNotExpressionAccess().getNotExpressionAction_0_0()); 
            // InternalOclMapping.g:777:2: ()
            // InternalOclMapping.g:777:3: 
            {
            }

             after(grammarAccess.getNotExpressionAccess().getNotExpressionAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group_0__0__Impl"


    // $ANTLR start "rule__NotExpression__Group_0__1"
    // InternalOclMapping.g:785:1: rule__NotExpression__Group_0__1 : rule__NotExpression__Group_0__1__Impl rule__NotExpression__Group_0__2 ;
    public final void rule__NotExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:789:1: ( rule__NotExpression__Group_0__1__Impl rule__NotExpression__Group_0__2 )
            // InternalOclMapping.g:790:2: rule__NotExpression__Group_0__1__Impl rule__NotExpression__Group_0__2
            {
            pushFollow(FOLLOW_4);
            rule__NotExpression__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NotExpression__Group_0__2();

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
    // $ANTLR end "rule__NotExpression__Group_0__1"


    // $ANTLR start "rule__NotExpression__Group_0__1__Impl"
    // InternalOclMapping.g:797:1: rule__NotExpression__Group_0__1__Impl : ( 'not' ) ;
    public final void rule__NotExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:801:1: ( ( 'not' ) )
            // InternalOclMapping.g:802:1: ( 'not' )
            {
            // InternalOclMapping.g:802:1: ( 'not' )
            // InternalOclMapping.g:803:2: 'not'
            {
             before(grammarAccess.getNotExpressionAccess().getNotKeyword_0_1()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getNotExpressionAccess().getNotKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group_0__1__Impl"


    // $ANTLR start "rule__NotExpression__Group_0__2"
    // InternalOclMapping.g:812:1: rule__NotExpression__Group_0__2 : rule__NotExpression__Group_0__2__Impl ;
    public final void rule__NotExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:816:1: ( rule__NotExpression__Group_0__2__Impl )
            // InternalOclMapping.g:817:2: rule__NotExpression__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NotExpression__Group_0__2__Impl();

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
    // $ANTLR end "rule__NotExpression__Group_0__2"


    // $ANTLR start "rule__NotExpression__Group_0__2__Impl"
    // InternalOclMapping.g:823:1: rule__NotExpression__Group_0__2__Impl : ( ( rule__NotExpression__OperandAssignment_0_2 ) ) ;
    public final void rule__NotExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:827:1: ( ( ( rule__NotExpression__OperandAssignment_0_2 ) ) )
            // InternalOclMapping.g:828:1: ( ( rule__NotExpression__OperandAssignment_0_2 ) )
            {
            // InternalOclMapping.g:828:1: ( ( rule__NotExpression__OperandAssignment_0_2 ) )
            // InternalOclMapping.g:829:2: ( rule__NotExpression__OperandAssignment_0_2 )
            {
             before(grammarAccess.getNotExpressionAccess().getOperandAssignment_0_2()); 
            // InternalOclMapping.g:830:2: ( rule__NotExpression__OperandAssignment_0_2 )
            // InternalOclMapping.g:830:3: rule__NotExpression__OperandAssignment_0_2
            {
            pushFollow(FOLLOW_2);
            rule__NotExpression__OperandAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getNotExpressionAccess().getOperandAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group_0__2__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_0__0"
    // InternalOclMapping.g:839:1: rule__PrimaryExpression__Group_0__0 : rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 ;
    public final void rule__PrimaryExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:843:1: ( rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 )
            // InternalOclMapping.g:844:2: rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1
            {
            pushFollow(FOLLOW_4);
            rule__PrimaryExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_0__1();

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
    // $ANTLR end "rule__PrimaryExpression__Group_0__0"


    // $ANTLR start "rule__PrimaryExpression__Group_0__0__Impl"
    // InternalOclMapping.g:851:1: rule__PrimaryExpression__Group_0__0__Impl : ( '(' ) ;
    public final void rule__PrimaryExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:855:1: ( ( '(' ) )
            // InternalOclMapping.g:856:1: ( '(' )
            {
            // InternalOclMapping.g:856:1: ( '(' )
            // InternalOclMapping.g:857:2: '('
            {
             before(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__0__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_0__1"
    // InternalOclMapping.g:866:1: rule__PrimaryExpression__Group_0__1 : rule__PrimaryExpression__Group_0__1__Impl rule__PrimaryExpression__Group_0__2 ;
    public final void rule__PrimaryExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:870:1: ( rule__PrimaryExpression__Group_0__1__Impl rule__PrimaryExpression__Group_0__2 )
            // InternalOclMapping.g:871:2: rule__PrimaryExpression__Group_0__1__Impl rule__PrimaryExpression__Group_0__2
            {
            pushFollow(FOLLOW_13);
            rule__PrimaryExpression__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_0__2();

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
    // $ANTLR end "rule__PrimaryExpression__Group_0__1"


    // $ANTLR start "rule__PrimaryExpression__Group_0__1__Impl"
    // InternalOclMapping.g:878:1: rule__PrimaryExpression__Group_0__1__Impl : ( ruleExpression ) ;
    public final void rule__PrimaryExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:882:1: ( ( ruleExpression ) )
            // InternalOclMapping.g:883:1: ( ruleExpression )
            {
            // InternalOclMapping.g:883:1: ( ruleExpression )
            // InternalOclMapping.g:884:2: ruleExpression
            {
             before(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__1__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_0__2"
    // InternalOclMapping.g:893:1: rule__PrimaryExpression__Group_0__2 : rule__PrimaryExpression__Group_0__2__Impl ;
    public final void rule__PrimaryExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:897:1: ( rule__PrimaryExpression__Group_0__2__Impl )
            // InternalOclMapping.g:898:2: rule__PrimaryExpression__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_0__2__Impl();

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
    // $ANTLR end "rule__PrimaryExpression__Group_0__2"


    // $ANTLR start "rule__PrimaryExpression__Group_0__2__Impl"
    // InternalOclMapping.g:904:1: rule__PrimaryExpression__Group_0__2__Impl : ( ')' ) ;
    public final void rule__PrimaryExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:908:1: ( ( ')' ) )
            // InternalOclMapping.g:909:1: ( ')' )
            {
            // InternalOclMapping.g:909:1: ( ')' )
            // InternalOclMapping.g:910:2: ')'
            {
             before(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__2__Impl"


    // $ANTLR start "rule__Literal__Group_0__0"
    // InternalOclMapping.g:920:1: rule__Literal__Group_0__0 : rule__Literal__Group_0__0__Impl rule__Literal__Group_0__1 ;
    public final void rule__Literal__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:924:1: ( rule__Literal__Group_0__0__Impl rule__Literal__Group_0__1 )
            // InternalOclMapping.g:925:2: rule__Literal__Group_0__0__Impl rule__Literal__Group_0__1
            {
            pushFollow(FOLLOW_14);
            rule__Literal__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Literal__Group_0__1();

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
    // $ANTLR end "rule__Literal__Group_0__0"


    // $ANTLR start "rule__Literal__Group_0__0__Impl"
    // InternalOclMapping.g:932:1: rule__Literal__Group_0__0__Impl : ( () ) ;
    public final void rule__Literal__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:936:1: ( ( () ) )
            // InternalOclMapping.g:937:1: ( () )
            {
            // InternalOclMapping.g:937:1: ( () )
            // InternalOclMapping.g:938:2: ()
            {
             before(grammarAccess.getLiteralAccess().getLiteralAction_0_0()); 
            // InternalOclMapping.g:939:2: ()
            // InternalOclMapping.g:939:3: 
            {
            }

             after(grammarAccess.getLiteralAccess().getLiteralAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_0__0__Impl"


    // $ANTLR start "rule__Literal__Group_0__1"
    // InternalOclMapping.g:947:1: rule__Literal__Group_0__1 : rule__Literal__Group_0__1__Impl ;
    public final void rule__Literal__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:951:1: ( rule__Literal__Group_0__1__Impl )
            // InternalOclMapping.g:952:2: rule__Literal__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Literal__Group_0__1__Impl();

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
    // $ANTLR end "rule__Literal__Group_0__1"


    // $ANTLR start "rule__Literal__Group_0__1__Impl"
    // InternalOclMapping.g:958:1: rule__Literal__Group_0__1__Impl : ( ( rule__Literal__ValueAssignment_0_1 ) ) ;
    public final void rule__Literal__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:962:1: ( ( ( rule__Literal__ValueAssignment_0_1 ) ) )
            // InternalOclMapping.g:963:1: ( ( rule__Literal__ValueAssignment_0_1 ) )
            {
            // InternalOclMapping.g:963:1: ( ( rule__Literal__ValueAssignment_0_1 ) )
            // InternalOclMapping.g:964:2: ( rule__Literal__ValueAssignment_0_1 )
            {
             before(grammarAccess.getLiteralAccess().getValueAssignment_0_1()); 
            // InternalOclMapping.g:965:2: ( rule__Literal__ValueAssignment_0_1 )
            // InternalOclMapping.g:965:3: rule__Literal__ValueAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Literal__ValueAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getValueAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_0__1__Impl"


    // $ANTLR start "rule__Literal__Group_1__0"
    // InternalOclMapping.g:974:1: rule__Literal__Group_1__0 : rule__Literal__Group_1__0__Impl rule__Literal__Group_1__1 ;
    public final void rule__Literal__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:978:1: ( rule__Literal__Group_1__0__Impl rule__Literal__Group_1__1 )
            // InternalOclMapping.g:979:2: rule__Literal__Group_1__0__Impl rule__Literal__Group_1__1
            {
            pushFollow(FOLLOW_15);
            rule__Literal__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Literal__Group_1__1();

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
    // $ANTLR end "rule__Literal__Group_1__0"


    // $ANTLR start "rule__Literal__Group_1__0__Impl"
    // InternalOclMapping.g:986:1: rule__Literal__Group_1__0__Impl : ( () ) ;
    public final void rule__Literal__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:990:1: ( ( () ) )
            // InternalOclMapping.g:991:1: ( () )
            {
            // InternalOclMapping.g:991:1: ( () )
            // InternalOclMapping.g:992:2: ()
            {
             before(grammarAccess.getLiteralAccess().getLiteralAction_1_0()); 
            // InternalOclMapping.g:993:2: ()
            // InternalOclMapping.g:993:3: 
            {
            }

             after(grammarAccess.getLiteralAccess().getLiteralAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_1__0__Impl"


    // $ANTLR start "rule__Literal__Group_1__1"
    // InternalOclMapping.g:1001:1: rule__Literal__Group_1__1 : rule__Literal__Group_1__1__Impl ;
    public final void rule__Literal__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:1005:1: ( rule__Literal__Group_1__1__Impl )
            // InternalOclMapping.g:1006:2: rule__Literal__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Literal__Group_1__1__Impl();

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
    // $ANTLR end "rule__Literal__Group_1__1"


    // $ANTLR start "rule__Literal__Group_1__1__Impl"
    // InternalOclMapping.g:1012:1: rule__Literal__Group_1__1__Impl : ( ( rule__Literal__ValueAssignment_1_1 ) ) ;
    public final void rule__Literal__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:1016:1: ( ( ( rule__Literal__ValueAssignment_1_1 ) ) )
            // InternalOclMapping.g:1017:1: ( ( rule__Literal__ValueAssignment_1_1 ) )
            {
            // InternalOclMapping.g:1017:1: ( ( rule__Literal__ValueAssignment_1_1 ) )
            // InternalOclMapping.g:1018:2: ( rule__Literal__ValueAssignment_1_1 )
            {
             before(grammarAccess.getLiteralAccess().getValueAssignment_1_1()); 
            // InternalOclMapping.g:1019:2: ( rule__Literal__ValueAssignment_1_1 )
            // InternalOclMapping.g:1019:3: rule__Literal__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Literal__ValueAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getValueAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_1__1__Impl"


    // $ANTLR start "rule__Literal__Group_2__0"
    // InternalOclMapping.g:1028:1: rule__Literal__Group_2__0 : rule__Literal__Group_2__0__Impl rule__Literal__Group_2__1 ;
    public final void rule__Literal__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:1032:1: ( rule__Literal__Group_2__0__Impl rule__Literal__Group_2__1 )
            // InternalOclMapping.g:1033:2: rule__Literal__Group_2__0__Impl rule__Literal__Group_2__1
            {
            pushFollow(FOLLOW_4);
            rule__Literal__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Literal__Group_2__1();

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
    // $ANTLR end "rule__Literal__Group_2__0"


    // $ANTLR start "rule__Literal__Group_2__0__Impl"
    // InternalOclMapping.g:1040:1: rule__Literal__Group_2__0__Impl : ( () ) ;
    public final void rule__Literal__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:1044:1: ( ( () ) )
            // InternalOclMapping.g:1045:1: ( () )
            {
            // InternalOclMapping.g:1045:1: ( () )
            // InternalOclMapping.g:1046:2: ()
            {
             before(grammarAccess.getLiteralAccess().getLiteralAction_2_0()); 
            // InternalOclMapping.g:1047:2: ()
            // InternalOclMapping.g:1047:3: 
            {
            }

             after(grammarAccess.getLiteralAccess().getLiteralAction_2_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_2__0__Impl"


    // $ANTLR start "rule__Literal__Group_2__1"
    // InternalOclMapping.g:1055:1: rule__Literal__Group_2__1 : rule__Literal__Group_2__1__Impl ;
    public final void rule__Literal__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:1059:1: ( rule__Literal__Group_2__1__Impl )
            // InternalOclMapping.g:1060:2: rule__Literal__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Literal__Group_2__1__Impl();

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
    // $ANTLR end "rule__Literal__Group_2__1"


    // $ANTLR start "rule__Literal__Group_2__1__Impl"
    // InternalOclMapping.g:1066:1: rule__Literal__Group_2__1__Impl : ( ( rule__Literal__ValueAssignment_2_1 ) ) ;
    public final void rule__Literal__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:1070:1: ( ( ( rule__Literal__ValueAssignment_2_1 ) ) )
            // InternalOclMapping.g:1071:1: ( ( rule__Literal__ValueAssignment_2_1 ) )
            {
            // InternalOclMapping.g:1071:1: ( ( rule__Literal__ValueAssignment_2_1 ) )
            // InternalOclMapping.g:1072:2: ( rule__Literal__ValueAssignment_2_1 )
            {
             before(grammarAccess.getLiteralAccess().getValueAssignment_2_1()); 
            // InternalOclMapping.g:1073:2: ( rule__Literal__ValueAssignment_2_1 )
            // InternalOclMapping.g:1073:3: rule__Literal__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Literal__ValueAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getValueAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_2__1__Impl"


    // $ANTLR start "rule__Model__ElementsAssignment"
    // InternalOclMapping.g:1082:1: rule__Model__ElementsAssignment : ( ruleFeature ) ;
    public final void rule__Model__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:1086:1: ( ( ruleFeature ) )
            // InternalOclMapping.g:1087:2: ( ruleFeature )
            {
            // InternalOclMapping.g:1087:2: ( ruleFeature )
            // InternalOclMapping.g:1088:3: ruleFeature
            {
             before(grammarAccess.getModelAccess().getElementsFeatureParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleFeature();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElementsFeatureParserRuleCall_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__Feature__ElementsAssignment_2"
    // InternalOclMapping.g:1097:1: rule__Feature__ElementsAssignment_2 : ( ruleInvariant ) ;
    public final void rule__Feature__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:1101:1: ( ( ruleInvariant ) )
            // InternalOclMapping.g:1102:2: ( ruleInvariant )
            {
            // InternalOclMapping.g:1102:2: ( ruleInvariant )
            // InternalOclMapping.g:1103:3: ruleInvariant
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
    // InternalOclMapping.g:1112:1: rule__Invariant__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Invariant__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:1116:1: ( ( RULE_ID ) )
            // InternalOclMapping.g:1117:2: ( RULE_ID )
            {
            // InternalOclMapping.g:1117:2: ( RULE_ID )
            // InternalOclMapping.g:1118:3: RULE_ID
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


    // $ANTLR start "rule__OrExpression__RightAssignment_1_2"
    // InternalOclMapping.g:1127:1: rule__OrExpression__RightAssignment_1_2 : ( ruleAndExpression ) ;
    public final void rule__OrExpression__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:1131:1: ( ( ruleAndExpression ) )
            // InternalOclMapping.g:1132:2: ( ruleAndExpression )
            {
            // InternalOclMapping.g:1132:2: ( ruleAndExpression )
            // InternalOclMapping.g:1133:3: ruleAndExpression
            {
             before(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAndExpression();

            state._fsp--;

             after(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__RightAssignment_1_2"


    // $ANTLR start "rule__AndExpression__RightAssignment_1_2"
    // InternalOclMapping.g:1142:1: rule__AndExpression__RightAssignment_1_2 : ( ruleNotExpression ) ;
    public final void rule__AndExpression__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:1146:1: ( ( ruleNotExpression ) )
            // InternalOclMapping.g:1147:2: ( ruleNotExpression )
            {
            // InternalOclMapping.g:1147:2: ( ruleNotExpression )
            // InternalOclMapping.g:1148:3: ruleNotExpression
            {
             before(grammarAccess.getAndExpressionAccess().getRightNotExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleNotExpression();

            state._fsp--;

             after(grammarAccess.getAndExpressionAccess().getRightNotExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__RightAssignment_1_2"


    // $ANTLR start "rule__NotExpression__OperandAssignment_0_2"
    // InternalOclMapping.g:1157:1: rule__NotExpression__OperandAssignment_0_2 : ( ruleNotExpression ) ;
    public final void rule__NotExpression__OperandAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:1161:1: ( ( ruleNotExpression ) )
            // InternalOclMapping.g:1162:2: ( ruleNotExpression )
            {
            // InternalOclMapping.g:1162:2: ( ruleNotExpression )
            // InternalOclMapping.g:1163:3: ruleNotExpression
            {
             before(grammarAccess.getNotExpressionAccess().getOperandNotExpressionParserRuleCall_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleNotExpression();

            state._fsp--;

             after(grammarAccess.getNotExpressionAccess().getOperandNotExpressionParserRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__OperandAssignment_0_2"


    // $ANTLR start "rule__Literal__ValueAssignment_0_1"
    // InternalOclMapping.g:1172:1: rule__Literal__ValueAssignment_0_1 : ( ( 'true' ) ) ;
    public final void rule__Literal__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:1176:1: ( ( ( 'true' ) ) )
            // InternalOclMapping.g:1177:2: ( ( 'true' ) )
            {
            // InternalOclMapping.g:1177:2: ( ( 'true' ) )
            // InternalOclMapping.g:1178:3: ( 'true' )
            {
             before(grammarAccess.getLiteralAccess().getValueTrueKeyword_0_1_0()); 
            // InternalOclMapping.g:1179:3: ( 'true' )
            // InternalOclMapping.g:1180:4: 'true'
            {
             before(grammarAccess.getLiteralAccess().getValueTrueKeyword_0_1_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getLiteralAccess().getValueTrueKeyword_0_1_0()); 

            }

             after(grammarAccess.getLiteralAccess().getValueTrueKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__ValueAssignment_0_1"


    // $ANTLR start "rule__Literal__ValueAssignment_1_1"
    // InternalOclMapping.g:1191:1: rule__Literal__ValueAssignment_1_1 : ( ( 'false' ) ) ;
    public final void rule__Literal__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:1195:1: ( ( ( 'false' ) ) )
            // InternalOclMapping.g:1196:2: ( ( 'false' ) )
            {
            // InternalOclMapping.g:1196:2: ( ( 'false' ) )
            // InternalOclMapping.g:1197:3: ( 'false' )
            {
             before(grammarAccess.getLiteralAccess().getValueFalseKeyword_1_1_0()); 
            // InternalOclMapping.g:1198:3: ( 'false' )
            // InternalOclMapping.g:1199:4: 'false'
            {
             before(grammarAccess.getLiteralAccess().getValueFalseKeyword_1_1_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getLiteralAccess().getValueFalseKeyword_1_1_0()); 

            }

             after(grammarAccess.getLiteralAccess().getValueFalseKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__ValueAssignment_1_1"


    // $ANTLR start "rule__Literal__ValueAssignment_2_1"
    // InternalOclMapping.g:1210:1: rule__Literal__ValueAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Literal__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOclMapping.g:1214:1: ( ( RULE_ID ) )
            // InternalOclMapping.g:1215:2: ( RULE_ID )
            {
            // InternalOclMapping.g:1215:2: ( RULE_ID )
            // InternalOclMapping.g:1216:3: RULE_ID
            {
             before(grammarAccess.getLiteralAccess().getValueIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLiteralAccess().getValueIDTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__ValueAssignment_2_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000000000D8010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080000L});

}