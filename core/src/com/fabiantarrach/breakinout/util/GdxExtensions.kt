package com.fabiantarrach.breakinout.util

import com.badlogic.gdx.utils.Array as GdxArray

fun <T> GdxArray<T>.clone() = GdxArray<T>(this)