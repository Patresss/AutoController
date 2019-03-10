package com.patres.automation.keyboard

import org.slf4j.LoggerFactory
import java.awt.event.KeyEvent


object KeyLoader {

    private val logger = LoggerFactory.getLogger(KeyLoader::class.java)

    fun getKey(character: Char): List<Int> {
        return when (character) {
            'a' -> listOf(KeyEvent.VK_A)
            'b' -> listOf(KeyEvent.VK_B)
            'c' -> listOf(KeyEvent.VK_C)
            'd' -> listOf(KeyEvent.VK_D)
            'e' -> listOf(KeyEvent.VK_E)
            'f' -> listOf(KeyEvent.VK_F)
            'g' -> listOf(KeyEvent.VK_G)
            'h' -> listOf(KeyEvent.VK_H)
            'i' -> listOf(KeyEvent.VK_I)
            'j' -> listOf(KeyEvent.VK_J)
            'k' -> listOf(KeyEvent.VK_K)
            'l' -> listOf(KeyEvent.VK_L)
            'm' -> listOf(KeyEvent.VK_M)
            'n' -> listOf(KeyEvent.VK_N)
            'o' -> listOf(KeyEvent.VK_O)
            'p' -> listOf(KeyEvent.VK_P)
            'q' -> listOf(KeyEvent.VK_Q)
            'r' -> listOf(KeyEvent.VK_R)
            's' -> listOf(KeyEvent.VK_S)
            't' -> listOf(KeyEvent.VK_T)
            'u' -> listOf(KeyEvent.VK_U)
            'v' -> listOf(KeyEvent.VK_V)
            'w' -> listOf(KeyEvent.VK_W)
            'x' -> listOf(KeyEvent.VK_X)
            'y' -> listOf(KeyEvent.VK_Y)
            'z' -> listOf(KeyEvent.VK_Z)
            'A' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_A)
            'B' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_B)
            'C' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_C)
            'D' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_D)
            'E' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_E)
            'F' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_F)
            'G' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_G)
            'H' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_H)
            'I' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_I)
            'J' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_J)
            'K' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_K)
            'L' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_L)
            'M' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_M)
            'N' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_N)
            'O' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_O)
            'P' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_P)
            'Q' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_Q)
            'R' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_R)
            'S' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_S)
            'T' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_T)
            'U' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_U)
            'V' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_V)
            'W' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_W)
            'X' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_X)
            'Y' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_Y)
            'Z' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_Z)
            'ą' -> listOf(KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_A)
            'ć' -> listOf(KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_C)
            'ę' -> listOf(KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_E)
            'ł' -> listOf(KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_L)
            'ń' -> listOf(KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_N)
            'ó' -> listOf(KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_O)
            'ś' -> listOf(KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_S)
            'ź' -> listOf(KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_X)
            'ż' -> listOf(KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_Z)
            'Ą' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_A)
            'Ć' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_C)
            'Ę' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_E)
            'Ł' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_L)
            'Ń' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_N)
            'Ó' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_O)
            'Ś' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_S)
            'Ź' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_X)
            'Ż' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_Z)
            '`' -> listOf(KeyEvent.VK_BACK_QUOTE)
            '0' -> listOf(KeyEvent.VK_0)
            '1' -> listOf(KeyEvent.VK_1)
            '2' -> listOf(KeyEvent.VK_2)
            '3' -> listOf(KeyEvent.VK_3)
            '4' -> listOf(KeyEvent.VK_4)
            '5' -> listOf(KeyEvent.VK_5)
            '6' -> listOf(KeyEvent.VK_6)
            '7' -> listOf(KeyEvent.VK_7)
            '8' -> listOf(KeyEvent.VK_8)
            '9' -> listOf(KeyEvent.VK_9)
            '-' -> listOf(KeyEvent.VK_MINUS)
            '=' -> listOf(KeyEvent.VK_EQUALS)
            '~' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_0)
            '!' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_1)
            '@' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_2)
            '#' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_3)
            '$' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_4)
            '%' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_5)
            '^' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_6)
            '&' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_7)
            '*' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_8)
            '(' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_9)
            ')' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_0)
            '_' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_MINUS)
            '+' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_QUOTE)
            '\t' -> listOf(KeyEvent.VK_TAB)
            '\n' -> listOf(KeyEvent.VK_ENTER)
            '[' -> listOf(KeyEvent.VK_OPEN_BRACKET)
            ']' -> listOf(KeyEvent.VK_CLOSE_BRACKET)
            '\\' -> listOf(KeyEvent.VK_BACK_SLASH)
            '{' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_OPEN_BRACKET)
            '}' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_CLOSE_BRACKET)
            '|' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_SLASH)
            ';' -> listOf(KeyEvent.VK_SEMICOLON)
            ':' -> listOf(KeyEvent.VK_COLON)
            '\'' -> listOf(KeyEvent.VK_QUOTE)
            '"' -> listOf(KeyEvent.VK_QUOTEDBL)
            ',' -> listOf(KeyEvent.VK_COMMA)
            '<' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_COMMA)
            '.' -> listOf(KeyEvent.VK_PERIOD)
            '>' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_PERIOD)
            '/' -> listOf(KeyEvent.VK_SLASH)
            '?' -> listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_SLASH)
            ' ' -> listOf(KeyEvent.VK_SPACE)
            else -> {
                logger.warn("Cannot type character $character")
                listOf(KeyEvent.VK_SHIFT, KeyEvent.VK_SLASH)
            }
        }
    }

}