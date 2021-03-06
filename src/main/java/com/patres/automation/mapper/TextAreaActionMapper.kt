package com.patres.automation.mapper

import com.patres.automation.action.AbstractAction
import com.patres.automation.action.text.PasteTextFromFieldAction
import com.patres.automation.action.text.TypeTextFromFieldAction
import com.patres.automation.excpetion.CannotFindRootSchemaException
import com.patres.automation.gui.controller.box.AbstractBox
import com.patres.automation.gui.controller.model.TextAreaActionController
import com.patres.automation.mapper.model.TextAreaActionSerialized
import com.patres.automation.parameter.received.ReceivedParameterConverter
import com.patres.automation.parameter.sent.SentParameter
import com.patres.automation.type.ActionBootTextArea
import javafx.beans.property.BooleanProperty

object TextAreaActionMapper : Mapper<TextAreaActionController, AbstractAction, TextAreaActionSerialized> {

    override fun controllerToModel(controller: TextAreaActionController, automationRunningProperty: BooleanProperty, parameters: Set<SentParameter>): AbstractAction {
        return calculateTextAreaModel(controller.actionBoot, controller.calculateParametrizedValue(parameters), automationRunningProperty, controller.box)
    }

    override fun controllerToSerialized(controller: TextAreaActionController): TextAreaActionSerialized {
        return controller.run {
            TextAreaActionSerialized(actionBoot, value)
        }
    }

    override fun serializedToController(serialized: TextAreaActionSerialized): TextAreaActionController {
        return TextAreaActionController(serialized.actionBootType).apply {
            value = serialized.value
        }
    }

    override fun serializedToModel(serialized: TextAreaActionSerialized, automationRunningProperty: BooleanProperty, parameters: Set<SentParameter>): AbstractAction {
        val parametrizedValue = ReceivedParameterConverter(serialized.value, parameters).replaceValue()
        return calculateTextAreaModel(serialized.actionBootType, parametrizedValue, automationRunningProperty)
    }

    private fun calculateTextAreaModel(actionType: ActionBootTextArea, value: String, automationRunningProperty: BooleanProperty, box: AbstractBox<*>? = null): AbstractAction {
        return when (actionType) {
            ActionBootTextArea.PASTE_TEXT -> PasteTextFromFieldAction(value, box)
            ActionBootTextArea.TYPE_TEXT -> TypeTextFromFieldAction(value, automationRunningProperty, box)
        }
    }


}