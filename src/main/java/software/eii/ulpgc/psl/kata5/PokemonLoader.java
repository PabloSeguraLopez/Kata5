package software.eii.ulpgc.psl.kata5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface PokemonLoader {
    List<Pokemon> load() throws IOException;
}
