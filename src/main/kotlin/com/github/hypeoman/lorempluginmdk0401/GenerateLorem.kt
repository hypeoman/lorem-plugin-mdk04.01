package com.github.hypeoman.lorempluginmdk0401

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.application.ApplicationManager

class GenerateLorem : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project: Project? = e.project
        val editor: Editor? = e.getData(CommonDataKeys.EDITOR)

        if (project != null && editor != null) {
            // Вставляем текст Lorem Ipsum
            val loremIpsumText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit..."
            WriteCommandAction.runWriteCommandAction(project) {
                editor.document.insertString(editor.caretModel.offset, loremIpsumText)
            }
        } else {
            Messages.showErrorDialog(
                    project,
                    "Не удалось получить доступ к проекту или редактору.",
                    "Ошибка"
            )
        }
    }
}
