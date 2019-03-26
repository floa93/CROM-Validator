package org.rosi.crom.validation.mapping.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.rosi.crom.validation.mapping.services.OclMappingGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOclMappingParser extends AbstractInternalAntlrParser {
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

        public InternalOclMappingParser(TokenStream input, OclMappingGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected OclMappingGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalOclMapping.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalOclMapping.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalOclMapping.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalOclMapping.g:71:1: ruleModel returns [EObject current=null] : ( (lv_elements_0_0= ruleFeature ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;



        	enterRule();

        try {
            // InternalOclMapping.g:77:2: ( ( (lv_elements_0_0= ruleFeature ) )* )
            // InternalOclMapping.g:78:2: ( (lv_elements_0_0= ruleFeature ) )*
            {
            // InternalOclMapping.g:78:2: ( (lv_elements_0_0= ruleFeature ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalOclMapping.g:79:3: (lv_elements_0_0= ruleFeature )
            	    {
            	    // InternalOclMapping.g:79:3: (lv_elements_0_0= ruleFeature )
            	    // InternalOclMapping.g:80:4: lv_elements_0_0= ruleFeature
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getElementsFeatureParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_elements_0_0=ruleFeature();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"elements",
            	    					lv_elements_0_0,
            	    					"org.rosi.crom.validation.mapping.OclMapping.Feature");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleFeature"
    // InternalOclMapping.g:100:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // InternalOclMapping.g:100:48: (iv_ruleFeature= ruleFeature EOF )
            // InternalOclMapping.g:101:2: iv_ruleFeature= ruleFeature EOF
            {
             newCompositeNode(grammarAccess.getFeatureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFeature=ruleFeature();

            state._fsp--;

             current =iv_ruleFeature; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFeature"


    // $ANTLR start "ruleFeature"
    // InternalOclMapping.g:107:1: ruleFeature returns [EObject current=null] : (otherlv_0= 'feature' this_Expression_1= ruleExpression ( (lv_elements_2_0= ruleInvariant ) )+ ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Expression_1 = null;

        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalOclMapping.g:113:2: ( (otherlv_0= 'feature' this_Expression_1= ruleExpression ( (lv_elements_2_0= ruleInvariant ) )+ ) )
            // InternalOclMapping.g:114:2: (otherlv_0= 'feature' this_Expression_1= ruleExpression ( (lv_elements_2_0= ruleInvariant ) )+ )
            {
            // InternalOclMapping.g:114:2: (otherlv_0= 'feature' this_Expression_1= ruleExpression ( (lv_elements_2_0= ruleInvariant ) )+ )
            // InternalOclMapping.g:115:3: otherlv_0= 'feature' this_Expression_1= ruleExpression ( (lv_elements_2_0= ruleInvariant ) )+
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getFeatureAccess().getFeatureKeyword_0());
            		

            			newCompositeNode(grammarAccess.getFeatureAccess().getExpressionParserRuleCall_1());
            		
            pushFollow(FOLLOW_5);
            this_Expression_1=ruleExpression();

            state._fsp--;


            			current = this_Expression_1;
            			afterParserOrEnumRuleCall();
            		
            // InternalOclMapping.g:127:3: ( (lv_elements_2_0= ruleInvariant ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalOclMapping.g:128:4: (lv_elements_2_0= ruleInvariant )
            	    {
            	    // InternalOclMapping.g:128:4: (lv_elements_2_0= ruleInvariant )
            	    // InternalOclMapping.g:129:5: lv_elements_2_0= ruleInvariant
            	    {

            	    					newCompositeNode(grammarAccess.getFeatureAccess().getElementsInvariantParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_elements_2_0=ruleInvariant();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFeatureRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elements",
            	    						lv_elements_2_0,
            	    						"org.rosi.crom.validation.mapping.OclMapping.Invariant");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeature"


    // $ANTLR start "entryRuleInvariant"
    // InternalOclMapping.g:150:1: entryRuleInvariant returns [EObject current=null] : iv_ruleInvariant= ruleInvariant EOF ;
    public final EObject entryRuleInvariant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvariant = null;


        try {
            // InternalOclMapping.g:150:50: (iv_ruleInvariant= ruleInvariant EOF )
            // InternalOclMapping.g:151:2: iv_ruleInvariant= ruleInvariant EOF
            {
             newCompositeNode(grammarAccess.getInvariantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInvariant=ruleInvariant();

            state._fsp--;

             current =iv_ruleInvariant; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleInvariant"


    // $ANTLR start "ruleInvariant"
    // InternalOclMapping.g:157:1: ruleInvariant returns [EObject current=null] : (otherlv_0= 'invariant' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleInvariant() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOclMapping.g:163:2: ( (otherlv_0= 'invariant' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalOclMapping.g:164:2: (otherlv_0= 'invariant' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalOclMapping.g:164:2: (otherlv_0= 'invariant' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalOclMapping.g:165:3: otherlv_0= 'invariant' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getInvariantAccess().getInvariantKeyword_0());
            		
            // InternalOclMapping.g:169:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOclMapping.g:170:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOclMapping.g:170:4: (lv_name_1_0= RULE_ID )
            // InternalOclMapping.g:171:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getInvariantAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInvariantRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInvariant"


    // $ANTLR start "entryRuleExpression"
    // InternalOclMapping.g:191:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalOclMapping.g:191:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalOclMapping.g:192:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalOclMapping.g:198:1: ruleExpression returns [EObject current=null] : this_OrExpression_0= ruleOrExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpression_0 = null;



        	enterRule();

        try {
            // InternalOclMapping.g:204:2: (this_OrExpression_0= ruleOrExpression )
            // InternalOclMapping.g:205:2: this_OrExpression_0= ruleOrExpression
            {

            		newCompositeNode(grammarAccess.getExpressionAccess().getOrExpressionParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_OrExpression_0=ruleOrExpression();

            state._fsp--;


            		current = this_OrExpression_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleOrExpression"
    // InternalOclMapping.g:216:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // InternalOclMapping.g:216:53: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalOclMapping.g:217:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
             newCompositeNode(grammarAccess.getOrExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;

             current =iv_ruleOrExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalOclMapping.g:223:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalOclMapping.g:229:2: ( (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalOclMapping.g:230:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalOclMapping.g:230:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalOclMapping.g:231:3: this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_8);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;


            			current = this_AndExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalOclMapping.g:239:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalOclMapping.g:240:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalOclMapping.g:240:4: ()
            	    // InternalOclMapping.g:241:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrExpressionAccess().getOrKeyword_1_1());
            	    			
            	    // InternalOclMapping.g:251:4: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalOclMapping.g:252:5: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalOclMapping.g:252:5: (lv_right_3_0= ruleAndExpression )
            	    // InternalOclMapping.g:253:6: lv_right_3_0= ruleAndExpression
            	    {

            	    						newCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_8);
            	    lv_right_3_0=ruleAndExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.rosi.crom.validation.mapping.OclMapping.AndExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalOclMapping.g:275:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalOclMapping.g:275:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalOclMapping.g:276:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
             newCompositeNode(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;

             current =iv_ruleAndExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalOclMapping.g:282:1: ruleAndExpression returns [EObject current=null] : (this_NotExpression_0= ruleNotExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_NotExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalOclMapping.g:288:2: ( (this_NotExpression_0= ruleNotExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotExpression ) ) )* ) )
            // InternalOclMapping.g:289:2: (this_NotExpression_0= ruleNotExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotExpression ) ) )* )
            {
            // InternalOclMapping.g:289:2: (this_NotExpression_0= ruleNotExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotExpression ) ) )* )
            // InternalOclMapping.g:290:3: this_NotExpression_0= ruleNotExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndExpressionAccess().getNotExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_9);
            this_NotExpression_0=ruleNotExpression();

            state._fsp--;


            			current = this_NotExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalOclMapping.g:298:3: ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotExpression ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalOclMapping.g:299:4: () otherlv_2= 'and' ( (lv_right_3_0= ruleNotExpression ) )
            	    {
            	    // InternalOclMapping.g:299:4: ()
            	    // InternalOclMapping.g:300:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,14,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndExpressionAccess().getAndKeyword_1_1());
            	    			
            	    // InternalOclMapping.g:310:4: ( (lv_right_3_0= ruleNotExpression ) )
            	    // InternalOclMapping.g:311:5: (lv_right_3_0= ruleNotExpression )
            	    {
            	    // InternalOclMapping.g:311:5: (lv_right_3_0= ruleNotExpression )
            	    // InternalOclMapping.g:312:6: lv_right_3_0= ruleNotExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightNotExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_right_3_0=ruleNotExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.rosi.crom.validation.mapping.OclMapping.NotExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleNotExpression"
    // InternalOclMapping.g:334:1: entryRuleNotExpression returns [EObject current=null] : iv_ruleNotExpression= ruleNotExpression EOF ;
    public final EObject entryRuleNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpression = null;


        try {
            // InternalOclMapping.g:334:54: (iv_ruleNotExpression= ruleNotExpression EOF )
            // InternalOclMapping.g:335:2: iv_ruleNotExpression= ruleNotExpression EOF
            {
             newCompositeNode(grammarAccess.getNotExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNotExpression=ruleNotExpression();

            state._fsp--;

             current =iv_ruleNotExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNotExpression"


    // $ANTLR start "ruleNotExpression"
    // InternalOclMapping.g:341:1: ruleNotExpression returns [EObject current=null] : ( ( () otherlv_1= 'not' ( (lv_operand_2_0= ruleNotExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression ) ;
    public final EObject ruleNotExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operand_2_0 = null;

        EObject this_PrimaryExpression_3 = null;



        	enterRule();

        try {
            // InternalOclMapping.g:347:2: ( ( ( () otherlv_1= 'not' ( (lv_operand_2_0= ruleNotExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression ) )
            // InternalOclMapping.g:348:2: ( ( () otherlv_1= 'not' ( (lv_operand_2_0= ruleNotExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression )
            {
            // InternalOclMapping.g:348:2: ( ( () otherlv_1= 'not' ( (lv_operand_2_0= ruleNotExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID||LA5_0==16||(LA5_0>=18 && LA5_0<=19)) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalOclMapping.g:349:3: ( () otherlv_1= 'not' ( (lv_operand_2_0= ruleNotExpression ) ) )
                    {
                    // InternalOclMapping.g:349:3: ( () otherlv_1= 'not' ( (lv_operand_2_0= ruleNotExpression ) ) )
                    // InternalOclMapping.g:350:4: () otherlv_1= 'not' ( (lv_operand_2_0= ruleNotExpression ) )
                    {
                    // InternalOclMapping.g:350:4: ()
                    // InternalOclMapping.g:351:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getNotExpressionAccess().getNotExpressionAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,15,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getNotExpressionAccess().getNotKeyword_0_1());
                    			
                    // InternalOclMapping.g:361:4: ( (lv_operand_2_0= ruleNotExpression ) )
                    // InternalOclMapping.g:362:5: (lv_operand_2_0= ruleNotExpression )
                    {
                    // InternalOclMapping.g:362:5: (lv_operand_2_0= ruleNotExpression )
                    // InternalOclMapping.g:363:6: lv_operand_2_0= ruleNotExpression
                    {

                    						newCompositeNode(grammarAccess.getNotExpressionAccess().getOperandNotExpressionParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=ruleNotExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNotExpressionRule());
                    						}
                    						set(
                    							current,
                    							"operand",
                    							lv_operand_2_0,
                    							"org.rosi.crom.validation.mapping.OclMapping.NotExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalOclMapping.g:382:3: this_PrimaryExpression_3= rulePrimaryExpression
                    {

                    			newCompositeNode(grammarAccess.getNotExpressionAccess().getPrimaryExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrimaryExpression_3=rulePrimaryExpression();

                    state._fsp--;


                    			current = this_PrimaryExpression_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNotExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalOclMapping.g:394:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalOclMapping.g:394:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalOclMapping.g:395:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalOclMapping.g:401:1: rulePrimaryExpression returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | this_Literal_3= ruleLiteral ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;

        EObject this_Literal_3 = null;



        	enterRule();

        try {
            // InternalOclMapping.g:407:2: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | this_Literal_3= ruleLiteral ) )
            // InternalOclMapping.g:408:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | this_Literal_3= ruleLiteral )
            {
            // InternalOclMapping.g:408:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | this_Literal_3= ruleLiteral )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID||(LA6_0>=18 && LA6_0<=19)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalOclMapping.g:409:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // InternalOclMapping.g:409:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // InternalOclMapping.g:410:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,16,FOLLOW_4); 

                    				newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_10);
                    this_Expression_1=ruleExpression();

                    state._fsp--;


                    				current = this_Expression_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOclMapping.g:428:3: this_Literal_3= ruleLiteral
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Literal_3=ruleLiteral();

                    state._fsp--;


                    			current = this_Literal_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleLiteral"
    // InternalOclMapping.g:440:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalOclMapping.g:440:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalOclMapping.g:441:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalOclMapping.g:447:1: ruleLiteral returns [EObject current=null] : ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= RULE_ID ) ) ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_0=null;
        Token lv_value_5_0=null;


        	enterRule();

        try {
            // InternalOclMapping.g:453:2: ( ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= RULE_ID ) ) ) ) )
            // InternalOclMapping.g:454:2: ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= RULE_ID ) ) ) )
            {
            // InternalOclMapping.g:454:2: ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= RULE_ID ) ) ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt7=1;
                }
                break;
            case 19:
                {
                alt7=2;
                }
                break;
            case RULE_ID:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalOclMapping.g:455:3: ( () ( (lv_value_1_0= 'true' ) ) )
                    {
                    // InternalOclMapping.g:455:3: ( () ( (lv_value_1_0= 'true' ) ) )
                    // InternalOclMapping.g:456:4: () ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalOclMapping.g:456:4: ()
                    // InternalOclMapping.g:457:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getLiteralAccess().getLiteralAction_0_0(),
                    						current);
                    				

                    }

                    // InternalOclMapping.g:463:4: ( (lv_value_1_0= 'true' ) )
                    // InternalOclMapping.g:464:5: (lv_value_1_0= 'true' )
                    {
                    // InternalOclMapping.g:464:5: (lv_value_1_0= 'true' )
                    // InternalOclMapping.g:465:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,18,FOLLOW_2); 

                    						newLeafNode(lv_value_1_0, grammarAccess.getLiteralAccess().getValueTrueKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLiteralRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_0, "true");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalOclMapping.g:479:3: ( () ( (lv_value_3_0= 'false' ) ) )
                    {
                    // InternalOclMapping.g:479:3: ( () ( (lv_value_3_0= 'false' ) ) )
                    // InternalOclMapping.g:480:4: () ( (lv_value_3_0= 'false' ) )
                    {
                    // InternalOclMapping.g:480:4: ()
                    // InternalOclMapping.g:481:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getLiteralAccess().getLiteralAction_1_0(),
                    						current);
                    				

                    }

                    // InternalOclMapping.g:487:4: ( (lv_value_3_0= 'false' ) )
                    // InternalOclMapping.g:488:5: (lv_value_3_0= 'false' )
                    {
                    // InternalOclMapping.g:488:5: (lv_value_3_0= 'false' )
                    // InternalOclMapping.g:489:6: lv_value_3_0= 'false'
                    {
                    lv_value_3_0=(Token)match(input,19,FOLLOW_2); 

                    						newLeafNode(lv_value_3_0, grammarAccess.getLiteralAccess().getValueFalseKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLiteralRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_3_0, "false");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalOclMapping.g:503:3: ( () ( (lv_value_5_0= RULE_ID ) ) )
                    {
                    // InternalOclMapping.g:503:3: ( () ( (lv_value_5_0= RULE_ID ) ) )
                    // InternalOclMapping.g:504:4: () ( (lv_value_5_0= RULE_ID ) )
                    {
                    // InternalOclMapping.g:504:4: ()
                    // InternalOclMapping.g:505:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getLiteralAccess().getLiteralAction_2_0(),
                    						current);
                    				

                    }

                    // InternalOclMapping.g:511:4: ( (lv_value_5_0= RULE_ID ) )
                    // InternalOclMapping.g:512:5: (lv_value_5_0= RULE_ID )
                    {
                    // InternalOclMapping.g:512:5: (lv_value_5_0= RULE_ID )
                    // InternalOclMapping.g:513:6: lv_value_5_0= RULE_ID
                    {
                    lv_value_5_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(lv_value_5_0, grammarAccess.getLiteralAccess().getValueIDTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLiteralRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_5_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000000000D8010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});

}