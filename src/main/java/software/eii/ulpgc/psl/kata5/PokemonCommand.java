package software.eii.ulpgc.psl.kata5;

import java.util.List;

public class PokemonCommand implements Command{
    List<Pokemon> pokemonList;

    public PokemonCommand(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    @Override
    public Output execute(Input input) {
        try{
            return outputOf(pokemonName(input.get("number")));
        } catch (Exception e) {
            return outputException();
        }
    }

    private Output outputException() {
        return new Output() {
            @Override
            public String result() {
                return "Not valid parameters";
            }

            @Override
            public int response() {
                return 403;
            }
        };
    }

    private Output outputOf(String name) {
        return new Output() {
            @Override
            public String result() {
                return name;
            }

            @Override
            public int response() {
                return 200;
            }
        };
    }

    private String pokemonName(String number) {
        return pokemonName(Integer.parseInt(number));
    }

    private String pokemonName(int number) {
        return pokemonList.stream()
                .filter(p->p.number()==number)
                .map(p->p.name())
                .findFirst()
                .orElse("Pokemon not found");
    }
}
