package software.eii.ulpgc.psl.kata5;

import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static Map<String, Command> commands = new HashMap<>();
    private Request request;
    private Response response;

    private CommandExecutor(Request request, Response output) {
        this.request = request;
        this.response = output;
    }
    public static CommandExecutor with(Request req, Response rep){
        return new CommandExecutor(req, rep);
    }
    public static void put(String name, Command command){
        commands.put(name, command);
    }
    public String execute(String name){
        Command.Output output = commands.get(name).execute(q->request.queryParams(q));
        response.status(output.response());
        return output.result();
    }

}
