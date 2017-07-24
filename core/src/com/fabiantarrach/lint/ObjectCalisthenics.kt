package com.fabiantarrach.lint

import com.fabiantarrach.breakinout.util.ifTrue
import java.io.File
import java.io.FileReader

fun main(args: Array<String>) {
	val mainDirectory = File("core/src/com/fabiantarrach/breakinout")
	// one level intendation
	noElse(mainDirectory)
	// wrap primitives
	// first class collections
	oneDotPerLine(mainDirectory)
	// no abbreviations
	linesSmaller50(mainDirectory)
	// 2 instance variables
	// no getter/setter
}

fun noElse(dir: File) {
	directoryIterator(dir) {
		if (FileReader(it).readText().contains("else"))
			println("${it.name} contains the 'else' keyword")
	}
}

fun oneDotPerLine(dir: File) {
	directoryIterator(dir) {
		FileReader(it).readLines().any {
			it.split("""\\.""").size > 2
		}.ifTrue {
			println("${it.name} has lines with more than one dot")
		}
	}
}

fun linesSmaller50(dir: File) {
	directoryIterator(dir) {
		val lines = FileReader(it).readLines().size
		if (lines > 50)
			println("${it.name} has $lines lines, 50 allowed")
	}
}

fun directoryIterator(dir: File, block: (File) -> Unit) {
	val files = dir.listFiles()
	for (file in files) {
		if (file.isDirectory) {
			directoryIterator(file, block)
		} else if (file.name.endsWith(".kt")) {
			block(file)
		}
	}
}