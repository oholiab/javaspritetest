Java Sprite Test
----------------

This project is an attempt to work out some basics for making a point and click
adventure game using Java and the Slick 2D game library which extends the
LWJGL. Initially I was attempting to use pure JRuby until it became clear that
doing so without any real prior knowledge of the Java libraries was going to be
hard.

The current plan is to try and write an engine and then perhaps embed JRuby for
the game scripting and other logic - however I may end up deciding to go to lua
or creating it in a state-based manner using YAML files like the hipster I am.

WHO KNOWS.

In it's current state, the keybindings are as follows:

* s: Stand animation (i.e. do nothing)
* t: Talk animation (I will just jabber on)
* q: Shrug animation (doesn't quite pingpong like I want it to yet)
* Esc: Exit.

The classpath rubbish is all in the .classpath file, so you should be able to
simply import the project in to Eclipse (ew... sorry) and download Slick from
whence it came and work out whence it should go (at the moment just import into
lib). If you're on a 64bit OS, you will need to download the latest version of 
LWJGL and replace the .jars and natives as Slick doesn't ship with the right
ones.

Future Versions
---------------

I will probably un-abstract out a little more of the animation looping and write
a few more helpers and then work out the best way to create a conversation menu
and script animations with dialogue choices and progressions. This may be where
the JRuby comes in. 