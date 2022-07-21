package dev.scheibelhofer;



import io.quarkus.picocli.runtime.annotations.TopCommand;
import picocli.CommandLine;

@TopCommand
@CommandLine.Command(mixinStandardHelpOptions = true, subcommands = { ListCommand.class, CreateCommand.class })
public class MainCommand {
}
