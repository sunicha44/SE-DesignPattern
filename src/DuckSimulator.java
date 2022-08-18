public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        //simulator.simulate();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }

    void simulate(AbstractDuckFactory duckFactory){
        // 2. Decorator Pattern ใช้ Echo และ ใช้ 2 decorator ร่วมกัน
        //Quackable mallardDuck = new QuackEcho(new MallardDuck());
        //Quackable redheadDuck = new QuackCounter(new QuackEcho(new RedheadDuck()));
        //Quackable redheadDuck = new QuackEcho(new QuackCounter(new RedheadDuck()));

        // 3. Abstract Pattern เพิ่มแบบที่มีทั้ง count และ echo
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        //Quackable mallardDuck = new MallardDuck();
        //Quackable redheadDuck = new RedheadDuck();
        //Quackable duckCall = new DuckCall();
        //Quackable rubberDuck = new RubberDuck();
        //Quackable gooseDuck = new GooseAdapter(new Goose());

        // 1. Adapter Pattern ใช้ pigeon adpter
        //Quackable pigeon = new PigeonAdater(new Pigeon());

        // 4. Composite Pattern เพิ่มจ่าฝูง quack ได้ 3 ครั้ง

        Flock flockOfDucks = new Flock();

        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);
        flockOfDucks.add(pigeon);

        simulate(flockOfDucks);

        //simulate(mallardDuck);
        //simulate(redheadDuck);
        //simulate(duckCall);
        //simulate(rubberDuck);

        //simulate(gooseDuck);
        //simulate(pigeon);

        System.out.println("The duck quacked "+QuackCounter.getQuacks()+" times");

    }

    void simulate(Quackable duck){
        duck.quack();
    }
}
