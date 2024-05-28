// Light Interface
interface Light {
    public void on();
    public void off();
}

// Command Interface
public interface Command {
    public void execute();
}

// LivingRoomLight Class
class LivingRoomLight implements Light {
    @Override
    public void on() {
        System.out.println("Switch on() Living Room Light");
    }

    @Override
    public void off() {
        System.out.println("Switch off() Living Room Light");
    }
}

// KitchenLight Class
class KitchenLight implements Light {
    @Override
    public void on() {
        System.out.println("Switch on() Kitchen Light");
    }

    @Override
    public void off() {
        System.out.println("Switch off() Kitchen Light");
    }
}

// LightOnCommand Class
class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

// LightOffCommand Class
class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

// RemoteController Class
class RemoteController {
    Command onCommand;
    Command offCommand;

    void setCommand(Command onCommand, Command offCommand) {
        this.onCommand = onCommand;
        this.offCommand = offCommand;
    }

    public void onButtonWasPushed() {
        onCommand.execute();
    }

    public void offButtonWasPushed() {
        offCommand.execute();
    }
}

// Test Class
class Test {
    public static void main(String[] args) {
        Light livingRoomLight = new LivingRoomLight();
        Light kitchenLight = new KitchenLight();

        RemoteController remoteController = new RemoteController();

        Command lightOnCommand = new LightOnCommand(livingRoomLight);
        Command lightOffCommand = new LightOffCommand(livingRoomLight);
        remoteController.setCommand(lightOnCommand, lightOffCommand);
        remoteController.onButtonWasPushed();
        remoteController.offButtonWasPushed();

        Command lightOnCommand2 = new LightOnCommand(kitchenLight);
        Command lightOffCommand2 = new LightOffCommand(kitchenLight);
        remoteController.setCommand(lightOnCommand2, lightOffCommand2);
        remoteController.onButtonWasPushed();
        remoteController.offButtonWasPushed();
    }
}

