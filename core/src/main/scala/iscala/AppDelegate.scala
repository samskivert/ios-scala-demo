//
// ios-scala-demo - a demo of building an iOS app using Scala
// https://github.com/samskivert/ios-scala-demo

package iscala

import cli.System.DateTime
import cli.MonoTouch.Dialog._
import cli.MonoTouch.Foundation._
import cli.MonoTouch.UIKit._

class AppDelegate extends UIApplicationDelegate {

  override def FinishedLaunching (app :UIApplication, options :NSDictionary) :Boolean = {
    val rootCtrl = new DialogViewController(new RootElement("Scala on iOS Demo") {
      Add(new Section("Language") {
        Add(new RootElement("Languages", new RadioGroup("langs", 1)) {
          Add(new Section {
            val langs = Seq("Java", "Scala", "Clojure", "JRuby", "Jython", "Groovy")
            langs.foreach { l => Add(new RadioElement(l, "langs")) }
          })
        })
        Add(new DateElement("Using Since", DateTime.get_Now()))
      })
      Add(new Section("Echo") {
        val entry = new EntryElement("Text", "Tap here to enter some text", "")
        Add(entry)
        Add(new StringElement("What did I enter?", action {
          val alert = new UIAlertView("This:", entry.get_Value, null, "OK", null)
          alert.Show()
        }))
      })
    })
    val nav = new UINavigationController(rootCtrl)
    window.set_RootViewController(nav)
    window.MakeKeyAndVisible()
    true
  }

  private def action (body : => Unit) =new NSAction(new NSAction.Method() {
    def Invoke = body
  })

  private lazy val window = new UIWindow(UIScreen.get_MainScreen.get_Bounds)
}
