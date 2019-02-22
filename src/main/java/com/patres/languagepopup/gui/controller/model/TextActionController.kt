package com.patres.languagepopup.gui.controller.model

import com.jfoenix.controls.JFXButton
import com.jfoenix.controls.JFXTextField
import com.patres.languagepopup.Main
import com.patres.languagepopup.gui.controller.PointerController
import javafx.fxml.FXML
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.stage.Stage
import javafx.stage.StageStyle

class TextActionController : LabelActionController() {

    @FXML
    lateinit var valueTextField: JFXTextField

    @FXML
    lateinit var validLabel: Label

    @FXML
    lateinit var pointButton: JFXButton


    val value: String
        get() = valueTextField.text


    @FXML
    override fun initialize() {
        super.initialize()
        setHandler()
    }

    private fun setHandler() {
        pointButton.setOnAction {
            Main.mainStage.isIconified = true
            showPointerStage()
        }
    }

    private fun showPointerStage() {
        val stage = Stage()
        stage.initStyle(StageStyle.TRANSPARENT)
        stage.title = "Set point"
        stage.scene = loadPointScene(stage)
        stage.isMaximized = true
        stage.show()
    }

    private fun loadPointScene(stage: Stage): Scene {
        val pointController = PointerController(stage, this)
        return pointController.scene
    }

}
