package com.fabiantarrach.breakinout.mainmenu

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.fabiantarrach.breakinout.util.GdxBitmapFont
import com.fabiantarrach.breakinout.util.GdxGlyphLayout

class MainMenuText {

	private val font = GdxBitmapFont()
	private val layout = GdxGlyphLayout()

	init {
		font.color = Color.WHITE
	}

	fun draw(sb: SpriteBatch) {
		layout.setText(font, "press left mouse button to start a new game") // TODO: wrap string in own class
		font.draw(sb, layout, -layout.width / 2, -layout.height / 2)
	}
}