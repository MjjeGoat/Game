public class Exit extends Command{
    @Override
    public String execute() {
        return "konec";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
