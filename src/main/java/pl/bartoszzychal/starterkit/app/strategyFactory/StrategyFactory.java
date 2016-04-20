package pl.bartoszzychal.starterkit.app.strategyFactory;

import pl.bartoszzychal.starterkit.app.strategy.Strategy;
import pl.bartoszzychal.starterkit.app.strategy.impl.LargeBrainStrategy;
import pl.bartoszzychal.starterkit.app.strategy.impl.MediumBrainStrategy;
import pl.bartoszzychal.starterkit.app.strategy.impl.SmallBrainStrategy;

public class StrategyFactory {
	public static Strategy getStrategy(Long idClient){
		Long strategyID = idClient%1;
		Strategy strategy = null;
		if(strategyID == 1){
			strategy = new SmallBrainStrategy();
		}else if(strategyID == 2) {
			strategy = new MediumBrainStrategy();
		}else if (strategyID == 3) {
			strategy = new LargeBrainStrategy();
		}
		return strategy;
	}
}
