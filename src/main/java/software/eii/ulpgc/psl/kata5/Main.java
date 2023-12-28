package software.eii.ulpgc.psl.kata5;

import spark.Spark;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Pokemon> pokemonList = CsvPokemonLoader.with(new File("Pokemon.csv")).load();
        CommandExecutor.put("pokemon", new PokemonCommand(pokemonList));
        Spark.port(8080);
        Spark.get("/pokemon", (req, res) -> CommandExecutor.with(req, res).execute("pokemon"));
    }
}
