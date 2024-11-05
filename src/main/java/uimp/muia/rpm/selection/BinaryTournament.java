package uimp.muia.rpm.selection;

import uimp.muia.rpm.Individual;
import uimp.muia.rpm.Selection;
import uimp.muia.rpm.Stochastic;

import java.util.List;
import java.util.Random;

public class BinaryTournament<I extends Individual> implements Selection<I>, Stochastic {

    private Random rand;

    public BinaryTournament() {
        this.rand = new Random();
    }

    @Override
    public I selectParent(List<I> individuals) {
        var first = pickRandomIndividual(individuals);
        var second = pickRandomIndividual(individuals);
        return first.compareTo(second) >= 0 ? first : second;
    }

    private I pickRandomIndividual(List<I> individuals) {
        return individuals.get(rand.nextInt(individuals.size()));
    }

    @Override
    public void setRandom(Random random) {
        this.rand = random;
    }
}
