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
	classSmaller50(mainDirectory)
	// 2 instance variables
	// no getter/setter
}

fun noElse(dir: File) =
		directoryIterator(dir) {
			if (FileReader(it).readText().contains("else"))
				println("${it.name} contains the 'else' keyword")
		}

fun oneDotPerLine(dir: File) =
		directoryIterator(dir) {
			FileReader(it).readLines().any {
				it.matches(Regex(""".*\\..*\\..*"""))
			}.ifTrue {
				println("${it.name} has lines with more than one dot")
			}
		}

fun classSmaller50(dir: File) =
		directoryIterator(dir) { file ->
			FileReader(file)
					.readLines()
					.dropWhile { !it.startsWith("class") && !it.startsWith("abstract") }
					.filter(String::isNotBlank)
					.takeIf { it.size > 50 }
					?.let {
						println("${it.size} lines in $file, 50 allowed (${it.size - 50}) ")
					}
		}

fun directoryIterator(dir: File, block: (File) -> Unit): Unit =
		dir.listFiles().forEach { file ->
			if (file.isDirectory) {
				directoryIterator(file, block)
			} else if (file.name.endsWith(".kt")) {
				block(file)
			}
		}