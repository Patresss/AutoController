package com.patres.automation.mapper

import com.patres.automation.gui.controller.model.SchemaGroupController
import com.patres.automation.mapper.model.SchemaGroupSerialized
import com.patres.automation.model.RootSchemaGroupModel
import com.patres.automation.model.SchemaGroupModel


object SchemaGroupMapper : Mapper<SchemaGroupController, SchemaGroupModel, SchemaGroupSerialized> {

    override fun controllerToModel(controller: SchemaGroupController): SchemaGroupModel {
        val actionBlockModels = controller.actionBlocks.map { it.toModel() }
        val iteration = controller.getNumberOfIteration()
        val automationRunningProperty = controller.root.automationRunningProperty
        return SchemaGroupModel(actionBlockModels, iteration, automationRunningProperty)
    }

    override fun controllerToSerialized(controller: SchemaGroupController): SchemaGroupSerialized {
        return controller.run {
            val serializedModels = actionBlocks.map { it.toSerialized() }
            SchemaGroupSerialized(serializedModels, groupNameTextField.text, iterationsTextField.text)
        }
    }

    override fun serializedToController(serialized: SchemaGroupSerialized, root: RootSchemaGroupModel, parent: SchemaGroupController?): SchemaGroupController {
        return SchemaGroupController(root, parent).apply {
            groupNameTextField.text = serialized.groupName
            iterationsTextField.text = serialized.numberOfIterations
            serialized.actionList
                    .map { it.serializedToController(root, this) }
                    .forEach { this.addActionBlockToBottom(it) }
        }
    }

}