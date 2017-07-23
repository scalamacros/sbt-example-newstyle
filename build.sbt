lazy val ScalaVersion = "2.12.2"
lazy val ScalamacrosVersion = "2.0.0-94-f03bbf3a"

lazy val newMacroSettings: Seq[Def.Setting[_]] = Seq(
  scalaVersion := ScalaVersion,
  resolvers += Resolver.bintrayRepo("scalamacros", "maven"),
  libraryDependencies += "org.scala-lang" % "scala-reflect" % ScalaVersion,
  addCompilerPlugin("org.scalamacros" %% "paradise" % "2.1.0" cross CrossVersion.full),
  addCompilerPlugin("org.scalamacros" % "scalac-plugin" % ScalamacrosVersion cross CrossVersion.full)
)

lazy val macros = project.settings(
  newMacroSettings,
  libraryDependencies += "org.scalamacros" %% "scalamacros" % ScalamacrosVersion
)

lazy val app = project.settings(
  newMacroSettings
).dependsOn(macros)
