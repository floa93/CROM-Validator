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
import org.rosi.crom.validation.mapping.services.FeatureMappingGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFeatureMappingParser extends AbstractInternalAntlrParser {
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

        public InternalFeatureMappingParser(TokenStream input, FeatureMappingGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected FeatureMappingGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalFeatureMapping.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalFeatureMapping.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalFeatureMapping.g:65:2: iv_ruleModel= ruleModel EOF
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
    // InternalFeatureMapping.g:71:1: ruleModel returns [EObject current=null] : ( ( (lv_elements_0_1= ruleUniversal | lv_elements_0_2= ruleFeature ) ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_1 = null;

        EObject lv_elements_0_2 = null;



        	enterRule();

        try {
            // InternalFeatureMapping.g:77:2: ( ( ( (lv_elements_0_1= ruleUniversal | lv_elements_0_2= ruleFeature ) ) )* )
            // InternalFeatureMapping.g:78:2: ( ( (lv_elements_0_1= ruleUniversal | lv_elements_0_2= ruleFeature ) ) )*
            {
            // InternalFeatureMapping.g:78:2: ( ( (lv_elements_0_1= ruleUniversal | lv_elements_0_2= ruleFeature ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=11 && LA2_0<=12)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalFeatureMapping.g:79:3: ( (lv_elements_0_1= ruleUniversal | lv_elements_0_2= ruleFeature ) )
            	    {
            	    // InternalFeatureMapping.g:79:3: ( (lv_elements_0_1= ruleUniversal | lv_elements_0_2= ruleFeature ) )
            	    // InternalFeatureMapping.g:80:4: (lv_elements_0_1= ruleUniversal | lv_elements_0_2= ruleFeature )
            	    {
            	    // InternalFeatureMapping.g:80:4: (lv_elements_0_1= ruleUniversal | lv_elements_0_2= ruleFeature )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==11) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==12) ) {
            	        alt1=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // InternalFeatureMapping.g:81:5: lv_elements_0_1= ruleUniversal
            	            {

            	            					newCompositeNode(grammarAccess.getModelAccess().getElementsUniversalParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_3);
            	            lv_elements_0_1=ruleUniversal();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getModelRule());
            	            					}
            	            					add(
            	            						current,
            	            						"elements",
            	            						lv_elements_0_1,
            	            						"org.rosi.crom.validation.mapping.FeatureMapping.Universal");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }
            	            break;
            	        case 2 :
            	            // InternalFeatureMapping.g:97:5: lv_elements_0_2= ruleFeature
            	            {

            	            					newCompositeNode(grammarAccess.getModelAccess().getElementsFeatureParserRuleCall_0_1());
            	            				
            	            pushFollow(FOLLOW_3);
            	            lv_elements_0_2=ruleFeature();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getModelRule());
            	            					}
            	            					add(
            	            						current,
            	            						"elements",
            	            						lv_elements_0_2,
            	            						"org.rosi.crom.validation.mapping.FeatureMapping.Feature");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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


    // $ANTLR start "entryRuleUniversal"
    // InternalFeatureMapping.g:118:1: entryRuleUniversal returns [EObject current=null] : iv_ruleUniversal= ruleUniversal EOF ;
    public final EObject entryRuleUniversal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUniversal = null;


        try {
            // InternalFeatureMapping.g:118:50: (iv_ruleUniversal= ruleUniversal EOF )
            // InternalFeatureMapping.g:119:2: iv_ruleUniversal= ruleUniversal EOF
            {
             newCompositeNode(grammarAccess.getUniversalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUniversal=ruleUniversal();

            state._fsp--;

             current =iv_ruleUniversal; 
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
    // $ANTLR end "entryRuleUniversal"


    // $ANTLR start "ruleUniversal"
    // InternalFeatureMapping.g:125:1: ruleUniversal returns [EObject current=null] : (otherlv_0= 'universal' ( (lv_elements_1_0= ruleInvariant ) )+ ) ;
    public final EObject ruleUniversal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_elements_1_0 = null;



        	enterRule();

        try {
            // InternalFeatureMapping.g:131:2: ( (otherlv_0= 'universal' ( (lv_elements_1_0= ruleInvariant ) )+ ) )
            // InternalFeatureMapping.g:132:2: (otherlv_0= 'universal' ( (lv_elements_1_0= ruleInvariant ) )+ )
            {
            // InternalFeatureMapping.g:132:2: (otherlv_0= 'universal' ( (lv_elements_1_0= ruleInvariant ) )+ )
            // InternalFeatureMapping.g:133:3: otherlv_0= 'universal' ( (lv_elements_1_0= ruleInvariant ) )+
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getUniversalAccess().getUniversalKeyword_0());
            		
            // InternalFeatureMapping.g:137:3: ( (lv_elements_1_0= ruleInvariant ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalFeatureMapping.g:138:4: (lv_elements_1_0= ruleInvariant )
            	    {
            	    // InternalFeatureMapping.g:138:4: (lv_elements_1_0= ruleInvariant )
            	    // InternalFeatureMapping.g:139:5: lv_elements_1_0= ruleInvariant
            	    {

            	    					newCompositeNode(grammarAccess.getUniversalAccess().getElementsInvariantParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_elements_1_0=ruleInvariant();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUniversalRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elements",
            	    						lv_elements_1_0,
            	    						"org.rosi.crom.validation.mapping.FeatureMapping.Invariant");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
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
    // $ANTLR end "ruleUniversal"


    // $ANTLR start "entryRuleFeature"
    // InternalFeatureMapping.g:160:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // InternalFeatureMapping.g:160:48: (iv_ruleFeature= ruleFeature EOF )
            // InternalFeatureMapping.g:161:2: iv_ruleFeature= ruleFeature EOF
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
    // InternalFeatureMapping.g:167:1: ruleFeature returns [EObject current=null] : (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ( (lv_elements_2_0= ruleInvariant ) )+ ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalFeatureMapping.g:173:2: ( (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ( (lv_elements_2_0= ruleInvariant ) )+ ) )
            // InternalFeatureMapping.g:174:2: (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ( (lv_elements_2_0= ruleInvariant ) )+ )
            {
            // InternalFeatureMapping.g:174:2: (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ( (lv_elements_2_0= ruleInvariant ) )+ )
            // InternalFeatureMapping.g:175:3: otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ( (lv_elements_2_0= ruleInvariant ) )+
            {
            otherlv_0=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getFeatureAccess().getFeatureKeyword_0());
            		
            // InternalFeatureMapping.g:179:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFeatureMapping.g:180:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFeatureMapping.g:180:4: (lv_name_1_0= RULE_ID )
            // InternalFeatureMapping.g:181:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFeatureAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFeatureRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalFeatureMapping.g:197:3: ( (lv_elements_2_0= ruleInvariant ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalFeatureMapping.g:198:4: (lv_elements_2_0= ruleInvariant )
            	    {
            	    // InternalFeatureMapping.g:198:4: (lv_elements_2_0= ruleInvariant )
            	    // InternalFeatureMapping.g:199:5: lv_elements_2_0= ruleInvariant
            	    {

            	    					newCompositeNode(grammarAccess.getFeatureAccess().getElementsInvariantParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_elements_2_0=ruleInvariant();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFeatureRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elements",
            	    						lv_elements_2_0,
            	    						"org.rosi.crom.validation.mapping.FeatureMapping.Invariant");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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
    // InternalFeatureMapping.g:220:1: entryRuleInvariant returns [EObject current=null] : iv_ruleInvariant= ruleInvariant EOF ;
    public final EObject entryRuleInvariant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvariant = null;


        try {
            // InternalFeatureMapping.g:220:50: (iv_ruleInvariant= ruleInvariant EOF )
            // InternalFeatureMapping.g:221:2: iv_ruleInvariant= ruleInvariant EOF
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
    // InternalFeatureMapping.g:227:1: ruleInvariant returns [EObject current=null] : (otherlv_0= 'invariant' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleInvariant() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalFeatureMapping.g:233:2: ( (otherlv_0= 'invariant' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalFeatureMapping.g:234:2: (otherlv_0= 'invariant' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalFeatureMapping.g:234:2: (otherlv_0= 'invariant' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalFeatureMapping.g:235:3: otherlv_0= 'invariant' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getInvariantAccess().getInvariantKeyword_0());
            		
            // InternalFeatureMapping.g:239:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFeatureMapping.g:240:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFeatureMapping.g:240:4: (lv_name_1_0= RULE_ID )
            // InternalFeatureMapping.g:241:5: lv_name_1_0= RULE_ID
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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});

}