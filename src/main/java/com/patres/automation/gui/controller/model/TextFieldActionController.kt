package com.patres.automation.gui.controller.model

import com.jfoenix.controls.JFXTextField
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.Label

open class TextFieldActionController : LabelActionController() {

    @FXML
    lateinit var valueTextField: JFXTextField

    @FXML
    lateinit var validLabel: Label

    override fun getNodesToSelect(): List<Node> = super.getNodesToSelect() + listOf(valueTextField)

    var value: String
        get() = valueTextField.text
        set(value) {
            valueTextField.text = value
        }

}
