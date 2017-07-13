package com.fabiantarrach.breakinout.mainmenu

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.graphics.g2d.SpriteBatch


class MainMenuText {

	private val font = BitmapFont()
	private val layout = GlyphLayout()

	init {
		font.color = Color.WHITE
	}

	fun draw(sb: SpriteBatch) {
		layout.setText(font, "press left mouse button to start a neu game")
//		val textWidth = layout.width
//		val textHeight = layout.height
//		(-
//				.map { it / 100f }80..80 step 20)
//				.forEach {
//					font.draw(sb, layout, it, it)
//				}

		font.draw(sb, layout, -layout.width / 2, -layout.height / 2)

	}
}