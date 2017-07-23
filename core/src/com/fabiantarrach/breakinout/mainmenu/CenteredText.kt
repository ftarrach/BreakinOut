package com.fabiantarrach.breakinout.mainmenu

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.fabiantarrach.breakinout.util.GdxBitmapFont

class CenteredText(text: String) {

	private val font = GdxBitmapFont()
	private val message = CenteredMessage(text)

	init {
		font.color = Color.WHITE
	}

	fun draw(sb: SpriteBatch) {
		message.draw(sb, font)
	}
}