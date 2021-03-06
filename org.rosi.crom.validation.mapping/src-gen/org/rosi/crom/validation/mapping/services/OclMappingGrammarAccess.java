/*
 * generated by Xtext 2.14.0
 */
package org.rosi.crom.validation.mapping.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class OclMappingGrammarAccess extends AbstractGrammarElementFinder {
	
	public class ModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.rosi.crom.validation.mapping.OclMapping.Model");
		private final Assignment cElementsAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cElementsFeatureParserRuleCall_0 = (RuleCall)cElementsAssignment.eContents().get(0);
		
		//Model:
		//	elements+=Feature*;
		@Override public ParserRule getRule() { return rule; }
		
		//elements+=Feature*
		public Assignment getElementsAssignment() { return cElementsAssignment; }
		
		//Feature
		public RuleCall getElementsFeatureParserRuleCall_0() { return cElementsFeatureParserRuleCall_0; }
	}
	public class FeatureElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.rosi.crom.validation.mapping.OclMapping.Feature");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cFeatureKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cExpressionParserRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Assignment cElementsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cElementsInvariantParserRuleCall_2_0 = (RuleCall)cElementsAssignment_2.eContents().get(0);
		
		//Feature:
		//	'feature' Expression
		//	elements+=Invariant+;
		@Override public ParserRule getRule() { return rule; }
		
		//'feature' Expression elements+=Invariant+
		public Group getGroup() { return cGroup; }
		
		//'feature'
		public Keyword getFeatureKeyword_0() { return cFeatureKeyword_0; }
		
		//Expression
		public RuleCall getExpressionParserRuleCall_1() { return cExpressionParserRuleCall_1; }
		
		//elements+=Invariant+
		public Assignment getElementsAssignment_2() { return cElementsAssignment_2; }
		
		//Invariant
		public RuleCall getElementsInvariantParserRuleCall_2_0() { return cElementsInvariantParserRuleCall_2_0; }
	}
	public class InvariantElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.rosi.crom.validation.mapping.OclMapping.Invariant");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cInvariantKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//Invariant:
		//	'invariant' name=ID;
		@Override public ParserRule getRule() { return rule; }
		
		//'invariant' name=ID
		public Group getGroup() { return cGroup; }
		
		//'invariant'
		public Keyword getInvariantKeyword_0() { return cInvariantKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}
	public class ExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.rosi.crom.validation.mapping.OclMapping.Expression");
		private final RuleCall cOrExpressionParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//Expression:
		//	OrExpression;
		@Override public ParserRule getRule() { return rule; }
		
		//OrExpression
		public RuleCall getOrExpressionParserRuleCall() { return cOrExpressionParserRuleCall; }
	}
	public class OrExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.rosi.crom.validation.mapping.OclMapping.OrExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAndExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cOrExpressionLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cOrKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightAndExpressionParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//OrExpression Expression:
		//	AndExpression ({OrExpression.left=current} 'or' right=AndExpression)*;
		@Override public ParserRule getRule() { return rule; }
		
		//AndExpression ({OrExpression.left=current} 'or' right=AndExpression)*
		public Group getGroup() { return cGroup; }
		
		//AndExpression
		public RuleCall getAndExpressionParserRuleCall_0() { return cAndExpressionParserRuleCall_0; }
		
		//({OrExpression.left=current} 'or' right=AndExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//{OrExpression.left=current}
		public Action getOrExpressionLeftAction_1_0() { return cOrExpressionLeftAction_1_0; }
		
		//'or'
		public Keyword getOrKeyword_1_1() { return cOrKeyword_1_1; }
		
		//right=AndExpression
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }
		
		//AndExpression
		public RuleCall getRightAndExpressionParserRuleCall_1_2_0() { return cRightAndExpressionParserRuleCall_1_2_0; }
	}
	public class AndExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.rosi.crom.validation.mapping.OclMapping.AndExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cNotExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cAndExpressionLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cAndKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightNotExpressionParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//AndExpression Expression:
		//	NotExpression ({AndExpression.left=current} 'and' right=NotExpression)*;
		@Override public ParserRule getRule() { return rule; }
		
		//NotExpression ({AndExpression.left=current} 'and' right=NotExpression)*
		public Group getGroup() { return cGroup; }
		
		//NotExpression
		public RuleCall getNotExpressionParserRuleCall_0() { return cNotExpressionParserRuleCall_0; }
		
		//({AndExpression.left=current} 'and' right=NotExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//{AndExpression.left=current}
		public Action getAndExpressionLeftAction_1_0() { return cAndExpressionLeftAction_1_0; }
		
		//'and'
		public Keyword getAndKeyword_1_1() { return cAndKeyword_1_1; }
		
		//right=NotExpression
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }
		
		//NotExpression
		public RuleCall getRightNotExpressionParserRuleCall_1_2_0() { return cRightNotExpressionParserRuleCall_1_2_0; }
	}
	public class NotExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.rosi.crom.validation.mapping.OclMapping.NotExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cNotExpressionAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Keyword cNotKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Assignment cOperandAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cOperandNotExpressionParserRuleCall_0_2_0 = (RuleCall)cOperandAssignment_0_2.eContents().get(0);
		private final RuleCall cPrimaryExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//NotExpression Expression:
		//	{NotExpression} 'not' operand=NotExpression | PrimaryExpression;
		@Override public ParserRule getRule() { return rule; }
		
		//{NotExpression} 'not' operand=NotExpression | PrimaryExpression
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//{NotExpression} 'not' operand=NotExpression
		public Group getGroup_0() { return cGroup_0; }
		
		//{NotExpression}
		public Action getNotExpressionAction_0_0() { return cNotExpressionAction_0_0; }
		
		//'not'
		public Keyword getNotKeyword_0_1() { return cNotKeyword_0_1; }
		
		//operand=NotExpression
		public Assignment getOperandAssignment_0_2() { return cOperandAssignment_0_2; }
		
		//NotExpression
		public RuleCall getOperandNotExpressionParserRuleCall_0_2_0() { return cOperandNotExpressionParserRuleCall_0_2_0; }
		
		//PrimaryExpression
		public RuleCall getPrimaryExpressionParserRuleCall_1() { return cPrimaryExpressionParserRuleCall_1; }
	}
	public class PrimaryExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.rosi.crom.validation.mapping.OclMapping.PrimaryExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final RuleCall cExpressionParserRuleCall_0_1 = (RuleCall)cGroup_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final RuleCall cLiteralParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//PrimaryExpression Expression:
		//	'(' Expression ')' | Literal;
		@Override public ParserRule getRule() { return rule; }
		
		//'(' Expression ')' | Literal
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'(' Expression ')'
		public Group getGroup_0() { return cGroup_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_0_0() { return cLeftParenthesisKeyword_0_0; }
		
		//Expression
		public RuleCall getExpressionParserRuleCall_0_1() { return cExpressionParserRuleCall_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_0_2() { return cRightParenthesisKeyword_0_2; }
		
		//Literal
		public RuleCall getLiteralParserRuleCall_1() { return cLiteralParserRuleCall_1; }
	}
	public class LiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.rosi.crom.validation.mapping.OclMapping.Literal");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cLiteralAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Assignment cValueAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final Keyword cValueTrueKeyword_0_1_0 = (Keyword)cValueAssignment_0_1.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cLiteralAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cValueAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final Keyword cValueFalseKeyword_1_1_0 = (Keyword)cValueAssignment_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Action cLiteralAction_2_0 = (Action)cGroup_2.eContents().get(0);
		private final Assignment cValueAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cValueIDTerminalRuleCall_2_1_0 = (RuleCall)cValueAssignment_2_1.eContents().get(0);
		
		//Literal Expression:
		//	{Literal} value='true' | {Literal} value='false' | {Literal} value=ID;
		@Override public ParserRule getRule() { return rule; }
		
		//{Literal} value='true' | {Literal} value='false' | {Literal} value=ID
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//{Literal} value='true'
		public Group getGroup_0() { return cGroup_0; }
		
		//{Literal}
		public Action getLiteralAction_0_0() { return cLiteralAction_0_0; }
		
		//value='true'
		public Assignment getValueAssignment_0_1() { return cValueAssignment_0_1; }
		
		//'true'
		public Keyword getValueTrueKeyword_0_1_0() { return cValueTrueKeyword_0_1_0; }
		
		//{Literal} value='false'
		public Group getGroup_1() { return cGroup_1; }
		
		//{Literal}
		public Action getLiteralAction_1_0() { return cLiteralAction_1_0; }
		
		//value='false'
		public Assignment getValueAssignment_1_1() { return cValueAssignment_1_1; }
		
		//'false'
		public Keyword getValueFalseKeyword_1_1_0() { return cValueFalseKeyword_1_1_0; }
		
		//{Literal} value=ID
		public Group getGroup_2() { return cGroup_2; }
		
		//{Literal}
		public Action getLiteralAction_2_0() { return cLiteralAction_2_0; }
		
		//value=ID
		public Assignment getValueAssignment_2_1() { return cValueAssignment_2_1; }
		
		//ID
		public RuleCall getValueIDTerminalRuleCall_2_1_0() { return cValueIDTerminalRuleCall_2_1_0; }
	}
	
	
	private final ModelElements pModel;
	private final FeatureElements pFeature;
	private final InvariantElements pInvariant;
	private final ExpressionElements pExpression;
	private final OrExpressionElements pOrExpression;
	private final AndExpressionElements pAndExpression;
	private final NotExpressionElements pNotExpression;
	private final PrimaryExpressionElements pPrimaryExpression;
	private final LiteralElements pLiteral;
	
	private final Grammar grammar;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public OclMappingGrammarAccess(GrammarProvider grammarProvider,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pModel = new ModelElements();
		this.pFeature = new FeatureElements();
		this.pInvariant = new InvariantElements();
		this.pExpression = new ExpressionElements();
		this.pOrExpression = new OrExpressionElements();
		this.pAndExpression = new AndExpressionElements();
		this.pNotExpression = new NotExpressionElements();
		this.pPrimaryExpression = new PrimaryExpressionElements();
		this.pLiteral = new LiteralElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.rosi.crom.validation.mapping.OclMapping".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Model:
	//	elements+=Feature*;
	public ModelElements getModelAccess() {
		return pModel;
	}
	
	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}
	
	//Feature:
	//	'feature' Expression
	//	elements+=Invariant+;
	public FeatureElements getFeatureAccess() {
		return pFeature;
	}
	
	public ParserRule getFeatureRule() {
		return getFeatureAccess().getRule();
	}
	
	//Invariant:
	//	'invariant' name=ID;
	public InvariantElements getInvariantAccess() {
		return pInvariant;
	}
	
	public ParserRule getInvariantRule() {
		return getInvariantAccess().getRule();
	}
	
	//Expression:
	//	OrExpression;
	public ExpressionElements getExpressionAccess() {
		return pExpression;
	}
	
	public ParserRule getExpressionRule() {
		return getExpressionAccess().getRule();
	}
	
	//OrExpression Expression:
	//	AndExpression ({OrExpression.left=current} 'or' right=AndExpression)*;
	public OrExpressionElements getOrExpressionAccess() {
		return pOrExpression;
	}
	
	public ParserRule getOrExpressionRule() {
		return getOrExpressionAccess().getRule();
	}
	
	//AndExpression Expression:
	//	NotExpression ({AndExpression.left=current} 'and' right=NotExpression)*;
	public AndExpressionElements getAndExpressionAccess() {
		return pAndExpression;
	}
	
	public ParserRule getAndExpressionRule() {
		return getAndExpressionAccess().getRule();
	}
	
	//NotExpression Expression:
	//	{NotExpression} 'not' operand=NotExpression | PrimaryExpression;
	public NotExpressionElements getNotExpressionAccess() {
		return pNotExpression;
	}
	
	public ParserRule getNotExpressionRule() {
		return getNotExpressionAccess().getRule();
	}
	
	//PrimaryExpression Expression:
	//	'(' Expression ')' | Literal;
	public PrimaryExpressionElements getPrimaryExpressionAccess() {
		return pPrimaryExpression;
	}
	
	public ParserRule getPrimaryExpressionRule() {
		return getPrimaryExpressionAccess().getRule();
	}
	
	//Literal Expression:
	//	{Literal} value='true' | {Literal} value='false' | {Literal} value=ID;
	public LiteralElements getLiteralAccess() {
		return pLiteral;
	}
	
	public ParserRule getLiteralRule() {
		return getLiteralAccess().getRule();
	}
	
	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	}
	
	//terminal INT returns ecore::EInt:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	}
	
	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"' | "'" ('\\' . | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	}
	
	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	}
}
