# Animation Demo

<center>

![](https://s9.gifyu.com/images/cube.gif)
<!--<img alt="demo gif here"  src="https://s9.gifyu.com/images/cube.gif" width="215" height="175" />-->
<br>

#### DISCLAIMER

This is a port of [Matthijs Hollemans'](https://github.com/hollance) code from Swift 3 to Java developed while following\
the respective [tutorial](https://machinethink.net/blog/3d-rendering-without-shaders/?fbclid=IwAR2Qajut7MOO6T5_O3yzCFej2RVlBGMTayCeecYgq2M8sGjSaS6-4sZidXI). The source code in Swift can also be found in this [repo](https://github.com/hollance/Swift-3D-Demo). They both\
contain lots of explainations and details.
<br><br>


#### SUMMARY

This is a simple animation demo which shows how to draw a 3D cube without using shaders.\
It illustrates what happens on the GPU when we use OpenGL or Metal to draw 3D objects.\
The animation is achieved without using any 3D APIs. The only rendering primitive used is a\
`setPixel()` method which paints individual pixels based on given coordinates and RGBA color\
values.

The demo isn't particularly fast or pretty, however, it demonstrates many of the concepts\
involved in 3D rendering. Additionally, a slider at the top allows for left and right camera\
movement.
<br><br>





#### LANGUAGE

Java 14.0.2

</center>