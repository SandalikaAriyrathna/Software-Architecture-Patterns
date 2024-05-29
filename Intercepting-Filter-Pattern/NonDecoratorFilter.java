import java.util.ArrayList;
import java.util.List;

public class NonDecoratorFilter {

    public interface IFilter {
        public void execute();
    }

    public static class AuthenticationFilter implements IFilter {
        @Override
        public void execute() {
            System.out.println("Authentication Filter");
        }
    }

    public static class InputValidationFilter implements IFilter {
        @Override
        public void execute() {
            System.out.println("Input Validation Filter");
        }
    }

    public static class DebuggingFilter implements IFilter {
        @Override
        public void execute() {
            System.out.println("Debugging Filter");
        }
    }

    public static class FilterChain {
        private List<IFilter> myFilters = new ArrayList<>();

        public void addFilter(IFilter iFilter) {
            myFilters.add(iFilter);
        }

        public void processFilter() {
            for (IFilter iFilter : myFilters) {
                iFilter.execute();
            }
            System.out.println();
        }
    }

    public static class FilterManager {
        public static void main(String[] args) {
            FilterChain filterChain = new FilterChain();

            filterChain.addFilter(new DebuggingFilter());
            filterChain.addFilter(new AuthenticationFilter());
            filterChain.addFilter(new InputValidationFilter());
            filterChain.processFilter();

            filterChain.addFilter(new AuthenticationFilter());
            filterChain.addFilter(new DebuggingFilter());
            filterChain.processFilter();
        }
    }
}
