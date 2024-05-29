public class NonDecoratorImpl {

  public interface IFilter {
      public void execute();
  }

  static class AuthenticationFilter implements IFilter {
      private IFilter target;

      public AuthenticationFilter() {}

      public AuthenticationFilter(IFilter target) {
          this.target = target;
      }

      @Override
      public void execute() {
        if (this.target != null) {
          this.target.execute();
        }
        System.out.println("Authentication Filter");
      }
  }

  static class InputValidationFilter implements IFilter {
      private IFilter target;

      public InputValidationFilter() {}

      public InputValidationFilter(IFilter target) {
          this.target = target;
      }

      @Override
      public void execute() {
        if (this.target != null) {
          this.target.execute();
        }
        System.out.println("Input Validation Filter");
      }
  }

  static class DebuggingFilter implements IFilter {
      private IFilter target;

      public DebuggingFilter() {}

      public DebuggingFilter(IFilter target) {
          this.target = target;
      }

      @Override
      public void execute() {
        if (this.target != null) {
          this.target.execute();
        }
        System.out.println("Debugging Filter");
      }
  }

  static class Test {
      public static void main(String[] args) {
          IFilter iFilter = new AuthenticationFilter(new DebuggingFilter(new InputValidationFilter()));
          iFilter.execute();

          System.out.println();
          new AuthenticationFilter(new DebuggingFilter()).execute();

          System.out.println();
          new AuthenticationFilter().execute();

          System.out.println();
          new InputValidationFilter(new DebuggingFilter(new AuthenticationFilter())).execute();
      }
  }
}
