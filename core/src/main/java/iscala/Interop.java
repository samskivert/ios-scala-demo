//
// $Id$

package iscala;

import cli.MonoTouch.Foundation.NSAction;

public class Interop
{
    public static NSAction action (final scala.Function0<?> body) {
        return new NSAction(new NSAction.Method() {
            public void Invoke () {
                body.apply();
            }
        });
    }
}
