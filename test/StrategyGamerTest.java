package cn.longyt.test;

import cn.longyt.pattern.strategy.impl.ComputeableStrategyOneImpl;
import cn.longyt.pattern.strategy.impl.ComputeableStrategyThreeImpl;
import cn.longyt.pattern.strategy.impl.ComputeableStrategyTwoImpl;
import cn.longyt.pattern.strategy.impl.StrategyGamer;

public class StrategyGamerTest {

    public static void main(String[] args) {

        StrategyGamer gamer = new StrategyGamer();
        gamer.setComputeableStrategy(new ComputeableStrategyOneImpl());
        double[] scoreArr = { 9.12, 9.25, 8.87, 9.13, 8.79, 9.08, 9.21, 9.05,8.91, 8.96 };
        System.out.println("策略1计算结果是："+gamer.getPersonScore(scoreArr));
        gamer.setComputeableStrategy(new ComputeableStrategyTwoImpl());
        System.out.println("策略2计算结果是："+gamer.getPersonScore(scoreArr));
        gamer.setComputeableStrategy(new ComputeableStrategyThreeImpl());
        System.out.println("策略3计算结果是："+gamer.getPersonScore(scoreArr));
    }
}
