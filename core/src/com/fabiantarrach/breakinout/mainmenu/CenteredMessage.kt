package com.fabiantarrach.breakinout.mainmenu

import com.fabiantarrach.breakinout.util.GdxBitmapFont
import com.fabiantarrach.breakinout.util.GdxGlyphLayout
import com.fabiantarrach.breakinout.util.GdxSpriteBatch

class CenteredMessage(private val message: String) {

	private val layout = GdxGlyphLayout()

	fun draw(sb: GdxSpriteBatch, font: GdxBitmapFont) {
		layout.setText(font, message)
		font.draw(sb, layout, -layout.width / 2, -layout.height / 2)
	}
}