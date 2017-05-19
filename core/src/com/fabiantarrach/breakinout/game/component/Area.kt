package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.util.Milliseconds

class Area(private val position: Position, private val size: Size) {
	fun xLeft() = position.xMinus(size.halfWidth())
	fun xRight() = position.xPlus(size.halfWidth())
	fun yBottom() = position.yMinus(size.halfHeight())
	fun yTop() = position.yPlus(size.halfHeight())
	fun xCenter() = position.xMinus(0f)
	fun yCenter() = position.yMinus(0f)
	@Deprecated("Setter") fun setPosition(x: Float, y: Float) = position.set(x, y)
	fun height(): Float = size.height()
	fun width(): Float = size.width()
	fun halfWidth(): Float = size.halfWidth()
	fun halfHeight(): Float = size.halfHeight()
	fun moveBy(velocity: Velocity, delta: Milliseconds) = position.moveBy(velocity, delta)
	fun getXOffsetTo(value: Float) = position.xMinus(value)
	fun isTopOrBottomOf(other: Area): Boolean = xCenter() >= other.xLeft() && xCenter() <= other.xRight()
	fun isTopOf(other: Area): Boolean = isTopOrBottomOf(other) && yCenter() > other.yCenter()
	fun isLeftOrRightOf(other: Area) = yCenter() >= other.yBottom() && yCenter() <= other.yTop()
}