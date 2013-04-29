//
// ios-scala-demo - a demo of building an iOS app using Scala
// https://github.com/samskivert/ios-scala-demo

using MonoTouch.Foundation;
using MonoTouch.UIKit;

namespace iscala
{
  // for some reason adding this C# attribute as an annotation in Java doesn't work; so we
  // use this little stub class that extends our actual app delegate and adds the attribute
  [Register ("AppDelegate")]
  public class CSAppDelegate : AppDelegate {
    public CSAppDelegate () {
    }
  }

  public class Application {
    static void Main (string[] args) {
      UIApplication.Main(args, null, "AppDelegate");
    }
  }
}
