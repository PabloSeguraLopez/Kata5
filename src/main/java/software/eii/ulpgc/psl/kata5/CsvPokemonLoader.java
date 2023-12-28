package software.eii.ulpgc.psl.kata5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvPokemonLoader implements PokemonLoader{
    File file;

    public CsvPokemonLoader(File file) {
        this.file = file;
    }

    public static CsvPokemonLoader with(File file){
        return new CsvPokemonLoader(file);
    }
    @Override
    public List<Pokemon> load() throws IOException {
        return load(new BufferedReader(new FileReader(file)));
    }

    private List<Pokemon> load(BufferedReader bf) throws IOException {
        bf.readLine();
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        while(true) {
            String line = bf.readLine();
            if (line == null) return pokemons;
            pokemons.add(toPokemon(line));
        }
    }

    private Pokemon toPokemon(String line) {
        return toPokemon(line.split(","));
    }

    private Pokemon toPokemon(String[] split) {
        int i = 0;
        return new Pokemon(
                Integer.parseInt(split[i++]),
                split[i++],
                split[i++],
                split.length == 13 ? split[i++] : "null",
                Integer.parseInt(split[i++]),
                Integer.parseInt(split[i++]),
                Integer.parseInt(split[i++]),
                Integer.parseInt(split[i++]),
                Integer.parseInt(split[i++]),
                Integer.parseInt(split[i++]),
                Integer.parseInt(split[i++]),
                Integer.parseInt(split[i++]),
                Boolean.parseBoolean(split[i++])
        );
    }
}
