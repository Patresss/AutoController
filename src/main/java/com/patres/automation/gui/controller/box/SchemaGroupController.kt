package com.patres.automation.gui.controller.box

import com.jfoenix.controls.JFXTextField
import com.jfoenix.controls.JFXToggleButton
import com.patres.automation.action.SchemaGroupModel
import com.patres.automation.mapper.SchemaGroupMapper
import com.patres.automation.mapper.model.SchemaGroupSerialized
import com.patres.automation.parameter.sent.SentParameter
import com.patres.automation.type.ActionBootSchema
import javafx.beans.property.BooleanProperty
import javafx.fxml.FXML
import javafx.scene.input.MouseEvent
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.VBox


class SchemaGroupController : AbstractBox<ActionBootSchema>("SchemaGroup.fxml") {

    @FXML
    lateinit var innerBox: VBox

    @FXML
    lateinit var groupNameTextField: JFXTextField

    @FXML
    lateinit var iterationsTextField: JFXTextField

    @FXML
    lateinit var turnOnToggleButton: JFXToggleButton

    @FXML
    lateinit var turnOffPane: AnchorPane


    @FXML
    fun initialize() {
        listOf(groupNameTextField, iterationsTextField, turnOnToggleButton).forEach { node -> node.addEventHandler(MouseEvent.MOUSE_PRESSED) { selectAction() } }
        turnOnToggleButton.selectedProperty().addListener { _, _, newValue -> calculateEnabled(newValue) }
        calculateEnabled(turnOnToggleButton.isSelected)
        listOf(groupNameTextField.textProperty(), iterationsTextField.textProperty(), turnOnToggleButton.selectedProperty()).forEach {
            property -> property.addListener { _, _, _ -> rootOrNull?.changeDetect() }
        }
    }

    fun calculateEnabled(turnOff: Boolean) {
        turnOffPane.isVisible = !turnOff
        innerBox.isDisable = !turnOff
    }

    fun getNumberOfIteration(): Int {
        return if (iterationsTextField.text == "INF") {
            Integer.MAX_VALUE
        } else {
            try {
                Integer.parseInt(iterationsTextField.text)
            } catch (nfe: NumberFormatException) {
                1
            }
        }
    }

    val abstractBlocks: List<AbstractBox<*>>
        get() = innerBox.children.filterIsInstance<AbstractBox<*>>()

    private val schemaGroups
        get() = abstractBlocks.filterIsInstance<SchemaGroupController>()

    val allChildrenActionBlocks: List<AbstractBox<*>>
        get() = abstractBlocks + schemaGroups.flatMap { it.allChildrenActionBlocks }

    override fun addNewAction(abstractBox: AbstractBox<*>) {
        innerBox.children.add(abstractBox)
    }

    override fun toSerialized(): SchemaGroupSerialized {
        return SchemaGroupMapper.controllerToSerialized(this)
    }

    override fun toModel(automationRunningProperty: BooleanProperty, parameters: Set<SentParameter>): SchemaGroupModel {
        return SchemaGroupMapper.controllerToModel(this, automationRunningProperty, parameters)
    }

    fun addActionBlockToList(abstractController: AbstractBox<*>, index: Int) {
        innerBox.children.add(index, abstractController)
    }

    fun removeNode(actionController: AbstractBox<*>) {
        innerBox.children.remove(actionController)
    }

    fun leaveGroupToUp(abstractController: AbstractBox<*>) {
        abstractController.schemaGroupParent?.removeNode(abstractController)
        val index = schemaGroupParent?.innerBox?.children?.indexOf(this) ?: 0
        schemaGroupParent?.addActionBlockToList(abstractController, index)
    }

    fun leaveGroupToDown(abstractController: AbstractBox<*>) {
        abstractController.schemaGroupParent?.removeNode(abstractController)
        val index = (schemaGroupParent?.innerBox?.children?.indexOf(this) ?: 0) + 1
        schemaGroupParent?.addActionBlockToList(abstractController, index)
    }

    fun moveActionBlockToTop(abstractController: AbstractBox<*>) {
        abstractController.schemaGroupParent?.removeNode(abstractController)
        innerBox.children.add(0, abstractController)
    }

    fun moveActionBlockToBottom(abstractController: AbstractBox<*>) {
        abstractController.schemaGroupParent?.removeNode(abstractController)
        innerBox.children.add(abstractController)
    }

}