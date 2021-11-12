package UseCases;

import Entities.Distributor;
import java.util.ArrayList;

public interface RankInterface {
    /**
     * Rank all distributors according to farmer preferences.
     *
     * @return A list of all distributors sorted by highest ranking.
     */
    ArrayList<Distributor> rankDistributors();
}
