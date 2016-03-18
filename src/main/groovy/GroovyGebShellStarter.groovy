
class GroovyGebShellStarter {
    public static void main(String[] args) {
        def command = [
                'java',
                '-cp', System.getProperty('java.class.path'),
                'org.codehaus.groovy.tools.shell.Main',
                '--color'
        ]

        def proc = new ProcessBuilder(command)
                .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                .redirectInput(ProcessBuilder.Redirect.INHERIT)
                .redirectError(ProcessBuilder.Redirect.INHERIT)
                .start()

        proc.waitFor()

        if (0 != proc.exitValue()) {
            throw new RuntimeException("console exited with status: ${proc.exitValue()}")
        }
    }
}
