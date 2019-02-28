package com.patres.automation.model

import com.patres.automation.Main
import com.patres.automation.excpetion.ApplicationException
import com.patres.automation.gui.controller.model.AutomationController
import com.patres.automation.gui.controller.model.RootSchemaGroupController
import com.patres.automation.gui.dialog.ExceptionHandlerDialog
import com.patres.automation.util.LoaderFactory
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.StringDescriptor
import org.slf4j.LoggerFactory

class RootSchemaGroupModel {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(RootSchemaGroupModel::class.java)
    }

    val controller: RootSchemaGroupController = LoaderFactory.createRootSchemaGroupController(this)

    var robot = com.sun.glass.ui.Application.GetApplication().createRobot()

    var schemaGroup = SchemaGroupModel(this, null)
        set(value) {
            field = value
            loadControllerContent()
        }

    var selectedModel: AutomationModel<out AutomationController>? = null
        set(value) {
            field = value
            controller.actionBarController.updateDisabledButtons()
        }

    var allChildrenActionBlocks = emptyList<AutomationModel<out AutomationController>>()
        get() = schemaGroup.allChildrenActionBlocks

    var allChildrenActionBlocksRoot = emptyList<AutomationModel<out AutomationController>>()
        get() = allChildrenActionBlocks + schemaGroup

    init {
        controller.actionBarController.initAfterSetModel()
        loadControllerContent()
    }

    fun addActionBlocks(actionBlock: AutomationModel<out AutomationController>) {
        schemaGroup.addActionBlocks(actionBlock)
    }

    fun unselectAllButton() {
        allChildrenActionBlocksRoot.forEach { it.unselectSelectActionButton() }
    }

    fun removeSelectedModel() {
        val futureSelectedNode = selectedModel?.findNodeOnTheTop()
        selectedModel?.let {
            it.parent?.removeNode(it)
            futureSelectedNode?.controller?.selectAction()
        }
    }

    fun addNodeAction(textActionModel: ActionNodeModel<out AutomationController>) {
        addNewActionModel(textActionModel)
    }

    fun addSchemaGroup() {
        val schemaGroupModel = SchemaGroupModel(this, schemaGroup)
        addNewActionModel(schemaGroupModel)
    }

    fun runAutomation() {
        try {
            schemaGroup.checkValidation()
            Main.mainStage.isIconified = true
            schemaGroup.runAction()
            Thread.sleep(200)
        } catch (e: ApplicationException) {
            LOGGER.error("ApplicationException: {}", e.message)
            val dialog = ExceptionHandlerDialog(e)
            dialog.show()
        } catch (e: Exception) {
            LOGGER.error("Exception: {}", e)
        } finally {
            Main.mainStage.isIconified = false
        }
    }

    private fun addNewActionModel(actionModel: AutomationModel<out AutomationController>) {
        val selectedModelVal = selectedModel
        when (selectedModelVal) {
            null -> addActionBlocks(actionModel)
            is SchemaGroupModel -> selectedModelVal.moveActionBlockToBottom(actionModel)
            is ActionNodeModel -> selectedModelVal.addActionBlockUnder(actionModel)
        }
        actionModel.controller.selectAction()
    }

     fun getSelectedShemaGroupModel(): SchemaGroupModel {
        val selectedModelVal = selectedModel
        return if (selectedModelVal != null && selectedModelVal is SchemaGroupModel) {
            selectedModelVal
        } else {
            schemaGroup
        }
    }

    private fun loadControllerContent() {
        controller.insidePane.content = schemaGroup.controller.getMainNode()
        schemaGroup.controller.mainSchemaBox.minHeightProperty().bind(controller.rootStackPane.heightProperty())
    }

}