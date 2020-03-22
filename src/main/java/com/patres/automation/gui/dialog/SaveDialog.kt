package com.patres.automation.gui.dialog

import com.jfoenix.controls.JFXDialog
import com.patres.automation.ApplicationLauncher

import com.patres.automation.gui.controller.TabContainer
import com.patres.automation.gui.custom.KeyboardButton
import com.patres.automation.settings.LanguageManager
import com.patres.automation.util.RootSchemaLoader
import com.patres.automation.util.fromBundle
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.control.Label
import javafx.scene.layout.StackPane
import java.text.MessageFormat

class SaveDialog(
        val tabContainer: TabContainer,
        val rootSchemaLoader: RootSchemaLoader
) : StackPane() {

    init {
        val fxmlLoader = FXMLLoader(javaClass.getResource("/fxml/dialog/SaveDialog.fxml"))
        fxmlLoader.setRoot(this)
        fxmlLoader.setController(this)
        fxmlLoader.resources = LanguageManager.getBundle()
        fxmlLoader.load<KeyboardButton>()
    }


    @FXML
    lateinit var label: Label

    var dialogKeeper: JFXDialog? = null

    @FXML
    fun initialize() {
        label.text = MessageFormat.format(fromBundle("dialog.save.saveFile"), tabContainer.rootSchema.getName())
    }

    @FXML
    fun save() {
        val saved = rootSchemaLoader.saveExistingRootSchema(tabContainer)
        if (saved) {
            ApplicationLauncher.mainController?.removeTab(tabContainer)
            dialogKeeper?.close()
        }
    }

    @FXML
    fun doNotSave() {
        rootSchemaLoader.removeTmpFile(tabContainer)
        ApplicationLauncher.mainController?.removeTab(tabContainer)
        dialogKeeper?.close()
    }

    @FXML
    fun cancel() {
        dialogKeeper?.close()
    }

}
