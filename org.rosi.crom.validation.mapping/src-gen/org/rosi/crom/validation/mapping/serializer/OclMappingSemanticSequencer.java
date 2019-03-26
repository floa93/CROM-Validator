/*
 * generated by Xtext 2.15.0
 */
package org.rosi.crom.validation.mapping.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.rosi.crom.validation.mapping.oclMapping.AndExpression;
import org.rosi.crom.validation.mapping.oclMapping.Invariant;
import org.rosi.crom.validation.mapping.oclMapping.Literal;
import org.rosi.crom.validation.mapping.oclMapping.Model;
import org.rosi.crom.validation.mapping.oclMapping.NotExpression;
import org.rosi.crom.validation.mapping.oclMapping.OclMappingPackage;
import org.rosi.crom.validation.mapping.oclMapping.OrExpression;
import org.rosi.crom.validation.mapping.services.OclMappingGrammarAccess;

@SuppressWarnings("all")
public class OclMappingSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private OclMappingGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == OclMappingPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case OclMappingPackage.AND_EXPRESSION:
				if (rule == grammarAccess.getExpressionRule()
						|| rule == grammarAccess.getOrExpressionRule()
						|| action == grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0()
						|| rule == grammarAccess.getAndExpressionRule()
						|| action == grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0()
						|| rule == grammarAccess.getNotExpressionRule()
						|| rule == grammarAccess.getPrimaryExpressionRule()) {
					sequence_AndExpression(context, (AndExpression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getFeatureRule()) {
					sequence_AndExpression_Feature(context, (AndExpression) semanticObject); 
					return; 
				}
				else break;
			case OclMappingPackage.INVARIANT:
				sequence_Invariant(context, (Invariant) semanticObject); 
				return; 
			case OclMappingPackage.LITERAL:
				if (rule == grammarAccess.getFeatureRule()) {
					sequence_Feature_Literal(context, (Literal) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getExpressionRule()
						|| rule == grammarAccess.getOrExpressionRule()
						|| action == grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0()
						|| rule == grammarAccess.getAndExpressionRule()
						|| action == grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0()
						|| rule == grammarAccess.getNotExpressionRule()
						|| rule == grammarAccess.getPrimaryExpressionRule()
						|| rule == grammarAccess.getLiteralRule()) {
					sequence_Literal(context, (Literal) semanticObject); 
					return; 
				}
				else break;
			case OclMappingPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case OclMappingPackage.NOT_EXPRESSION:
				if (rule == grammarAccess.getFeatureRule()) {
					sequence_Feature_NotExpression(context, (NotExpression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getExpressionRule()
						|| rule == grammarAccess.getOrExpressionRule()
						|| action == grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0()
						|| rule == grammarAccess.getAndExpressionRule()
						|| action == grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0()
						|| rule == grammarAccess.getNotExpressionRule()
						|| rule == grammarAccess.getPrimaryExpressionRule()) {
					sequence_NotExpression(context, (NotExpression) semanticObject); 
					return; 
				}
				else break;
			case OclMappingPackage.OR_EXPRESSION:
				if (rule == grammarAccess.getFeatureRule()) {
					sequence_Feature_OrExpression(context, (OrExpression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getExpressionRule()
						|| rule == grammarAccess.getOrExpressionRule()
						|| action == grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0()
						|| rule == grammarAccess.getAndExpressionRule()
						|| action == grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0()
						|| rule == grammarAccess.getNotExpressionRule()
						|| rule == grammarAccess.getPrimaryExpressionRule()) {
					sequence_OrExpression(context, (OrExpression) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Expression returns AndExpression
	 *     OrExpression returns AndExpression
	 *     OrExpression.OrExpression_1_0 returns AndExpression
	 *     AndExpression returns AndExpression
	 *     AndExpression.AndExpression_1_0 returns AndExpression
	 *     NotExpression returns AndExpression
	 *     PrimaryExpression returns AndExpression
	 *
	 * Constraint:
	 *     (left=AndExpression_AndExpression_1_0 right=NotExpression)
	 */
	protected void sequence_AndExpression(ISerializationContext context, AndExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclMappingPackage.Literals.AND_EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclMappingPackage.Literals.AND_EXPRESSION__LEFT));
			if (transientValues.isValueTransient(semanticObject, OclMappingPackage.Literals.AND_EXPRESSION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclMappingPackage.Literals.AND_EXPRESSION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAndExpressionAccess().getRightNotExpressionParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Feature returns AndExpression
	 *
	 * Constraint:
	 *     (left=AndExpression_AndExpression_1_0 right=NotExpression elements+=Invariant+)
	 */
	protected void sequence_AndExpression_Feature(ISerializationContext context, AndExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Feature returns Literal
	 *
	 * Constraint:
	 *     ((value='true' | value='false' | value=ID) elements+=Invariant+)
	 */
	protected void sequence_Feature_Literal(ISerializationContext context, Literal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Feature returns NotExpression
	 *
	 * Constraint:
	 *     (operand=NotExpression elements+=Invariant+)
	 */
	protected void sequence_Feature_NotExpression(ISerializationContext context, NotExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Feature returns OrExpression
	 *
	 * Constraint:
	 *     (left=OrExpression_OrExpression_1_0 right=AndExpression elements+=Invariant+)
	 */
	protected void sequence_Feature_OrExpression(ISerializationContext context, OrExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Invariant returns Invariant
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Invariant(ISerializationContext context, Invariant semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclMappingPackage.Literals.INVARIANT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclMappingPackage.Literals.INVARIANT__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getInvariantAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Literal
	 *     OrExpression returns Literal
	 *     OrExpression.OrExpression_1_0 returns Literal
	 *     AndExpression returns Literal
	 *     AndExpression.AndExpression_1_0 returns Literal
	 *     NotExpression returns Literal
	 *     PrimaryExpression returns Literal
	 *     Literal returns Literal
	 *
	 * Constraint:
	 *     (value='true' | value='false' | value=ID)
	 */
	protected void sequence_Literal(ISerializationContext context, Literal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     elements+=Feature+
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns NotExpression
	 *     OrExpression returns NotExpression
	 *     OrExpression.OrExpression_1_0 returns NotExpression
	 *     AndExpression returns NotExpression
	 *     AndExpression.AndExpression_1_0 returns NotExpression
	 *     NotExpression returns NotExpression
	 *     PrimaryExpression returns NotExpression
	 *
	 * Constraint:
	 *     operand=NotExpression
	 */
	protected void sequence_NotExpression(ISerializationContext context, NotExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclMappingPackage.Literals.NOT_EXPRESSION__OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclMappingPackage.Literals.NOT_EXPRESSION__OPERAND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNotExpressionAccess().getOperandNotExpressionParserRuleCall_0_2_0(), semanticObject.getOperand());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns OrExpression
	 *     OrExpression returns OrExpression
	 *     OrExpression.OrExpression_1_0 returns OrExpression
	 *     AndExpression returns OrExpression
	 *     AndExpression.AndExpression_1_0 returns OrExpression
	 *     NotExpression returns OrExpression
	 *     PrimaryExpression returns OrExpression
	 *
	 * Constraint:
	 *     (left=OrExpression_OrExpression_1_0 right=AndExpression)
	 */
	protected void sequence_OrExpression(ISerializationContext context, OrExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, OclMappingPackage.Literals.OR_EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclMappingPackage.Literals.OR_EXPRESSION__LEFT));
			if (transientValues.isValueTransient(semanticObject, OclMappingPackage.Literals.OR_EXPRESSION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OclMappingPackage.Literals.OR_EXPRESSION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
}
