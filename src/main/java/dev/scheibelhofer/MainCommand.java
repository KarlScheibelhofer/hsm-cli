package dev.scheibelhofer;



import io.quarkus.picocli.runtime.annotations.TopCommand;
import picocli.CommandLine;

@TopCommand
@CommandLine.Command(name = "hsmcli", 
                     mixinStandardHelpOptions = true, 
                     subcommands = { ListCommand.class, CreateCommand.class },
                     description = "Command-Line client for the HSM-API")
public class MainCommand {
}
