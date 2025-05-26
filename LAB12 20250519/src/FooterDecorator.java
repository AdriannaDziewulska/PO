public class FooterDecorator extends EmailDecorator {
    public FooterDecorator(Email wrappee) {
        super(wrappee);
    }

    @Override
    public String getContent() {
        return super.getContent() + "\nZespół Obsługi Klienta";
    }
}
