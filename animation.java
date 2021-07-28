import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Point;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;


/* 
A vertex describes an (x,y,z) position in 3D space but also the color of the triangle at that vertex 
and a normal vector for lighting calculations. You can also add extra information such as texture 
mapping coordinates, as well as any other data you want to associate with a vertex
*/
class Vertex {

    /* coordinates */
    public float x=0, y=0, z=0;

    /* color */
    public float r=0, g=0, b=0, a=1;

    /* normal vector (for lighting) */
    public float nx=0, ny=0, nz=0;

    public Vertex() { }

    /*public Vertex(Vertex vertex) {
        this.x = vertex.x;
        this.y = vertex.y;
        this.z = vertex.z;
        this.r = vertex.r;
        this.g = vertex.g;
        this.b = vertex.b;
        this.a = vertex.a;
        this.nx = vertex.nx;
        this.ny = vertex.ny;
        this.nz = vertex.nz;
    }*/

    public Vertex(float x, float y, float z, float r, float g, float b, float a, float nx, float ny, float nz) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
        this.nx = nx;
        this.ny = ny;
        this.nz = nz;
    }
}


/* A triangle has three vertices (aka "faces") */
class Triangle {
    public ArrayList<Vertex> vertices = new ArrayList<Vertex>(Arrays.asList(null,null,null));

}


/* The model is just a list of triangles */
class CubeModel {
    public ArrayList<Triangle> triangles = new ArrayList<Triangle>();

    /* deep copy constructor */
    public CubeModel(CubeModel model) {
        this.triangles = new ArrayList<Triangle>();
        
        Vertex vertex;
        Triangle triangle;

        float x, y, z, r, g, b, a, nx, ny, nz;

        for (int i=0; i<12; i++) {
            triangle = new Triangle();

            for (int j=0; j<3; j++) {
                x = model.triangles.get(i).vertices.get(j).x;
                y = model.triangles.get(i).vertices.get(j).y;
                z = model.triangles.get(i).vertices.get(j).z;
                r = model.triangles.get(i).vertices.get(j).r;
                g = model.triangles.get(i).vertices.get(j).g;
                b = model.triangles.get(i).vertices.get(j).b;
                a = model.triangles.get(i).vertices.get(j).a;
                nx = model.triangles.get(i).vertices.get(j).nx;
                ny = model.triangles.get(i).vertices.get(j).ny;
                nz = model.triangles.get(i).vertices.get(j).nz;

                vertex = new Vertex(x, y, z, r, g, b, a, nx, ny, nz);

                triangle.vertices.add(j, vertex); 
            }
            this.triangles.add(i, triangle);
        }
    }

    public CubeModel() {
        
        Triangle triangle;

        triangle = new Triangle();
        triangle.vertices.add(0, new Vertex(-10, -10, 10, 0, 0, 1, 1, 0, 0, 1));
        triangle.vertices.add(1, new Vertex(-10, 10, 10, 0, 0, 1, 1, 0, 0, 1));
        triangle.vertices.add(2, new Vertex(10, -10, 10, 0, 0, 1, 1, 0, 0, 1));
        triangles.add(0, triangle);

        triangle = new Triangle();
        triangle.vertices.add(0, new Vertex(-10, 10, 10, 0, 0, 1, 1, 0, 0, 1));
        triangle.vertices.add(1, new Vertex(10, -10, 10, 0, 0, 1, 1, 0, 0, 1));
        triangle.vertices.add(2, new Vertex(10, 10, 10, 0, 0, 1, 1, 0, 0, 1));
        triangles.add(1, triangle);

        triangle = new Triangle();
        triangle.vertices.add(0, new Vertex(-10, -10, -10, 1, 0, 0, 1, 0, 0, -1));
        triangle.vertices.add(1, new Vertex(10, -10, -10, 0, 1, 0, 1, 0, 0, -1));
        triangle.vertices.add(2, new Vertex(10, 10, -10, 0, 0, 1, 1, 0, 0, -1));
        triangles.add(2, triangle);

        triangle = new Triangle();
        triangle.vertices.add(0, new Vertex(-10, -10, -10, 1, 1, 0, 1, 0, 0, -1));
        triangle.vertices.add(1, new Vertex(10, 10, -10, 0, 1, 1, 1, 0, 0, -1));
        triangle.vertices.add(2, new Vertex(-10, 10, -10, 1, 0, 1, 1, 0, 0, -1));
        triangles.add(3, triangle);

        triangle = new Triangle();
        triangle.vertices.add(0, new Vertex(-10, 10, -10, 1, 0, 0, 1, 0, 1, 0));
        triangle.vertices.add(1, new Vertex(-10, 10, 10, 1, 0, 0, 1, 0, 1, 0));
        triangle.vertices.add(2, new Vertex(10, 10, -10, 1, 0, 0, 1, 0, 1, 0));
        triangles.add(4, triangle);

        triangle = new Triangle();
        triangle.vertices.add(0, new Vertex(-10, 10, 10, 1, 0, 0, 1, 0, 1, 0));
        triangle.vertices.add(1, new Vertex(10, 10, -10, 1, 0, 0, 1, 0, 1, 0));
        triangle.vertices.add(2, new Vertex(10, 10, 10, 1, 0, 0, 1, 0, 1, 0));
        triangles.add(5, triangle);

        triangle = new Triangle();
        triangle.vertices.add(0, new Vertex(-10, -10, -10, 1, 1, 1, 1, 0, -1, 0));
        triangle.vertices.add(1, new Vertex(10, -10, -10, 1, 1, 1, 1, 0, -1, 0));
        triangle.vertices.add(2, new Vertex(-10, -10, 10, 1, 1, 1, 1, 0, -1, 0));
        triangles.add(6, triangle);

        triangle = new Triangle();
        triangle.vertices.add(0, new Vertex(-10, -10, 10, 1, 1, 1, 1, 0, -1, 0));
        triangle.vertices.add(1, new Vertex(10, -10, 10, 1, 1, 1, 1, 0, -1, 0));
        triangle.vertices.add(2, new Vertex(10, -10, -10, 1, 1, 1, 1, 0, -1, 0));
        triangles.add(7, triangle);

        triangle = new Triangle();
        triangle.vertices.add(0, new Vertex(10, -10, -10, 0, 1, 0, 1, 1, 0, 0));
        triangle.vertices.add(1, new Vertex(10, -10, 10, 0, 1, 0, 1, 1, 0, 0));
        triangle.vertices.add(2, new Vertex(10, 10, -10, 0, 1, 0, 1, 1, 0, 0));
        triangles.add(8, triangle);

        triangle = new Triangle();
        triangle.vertices.add(0, new Vertex(10, -10, 10, 0, 1, 0, 1, 1, 0, 0));
        triangle.vertices.add(1, new Vertex(10, 10, -10, 0, 1, 0, 1, 1, 0, 0));
        triangle.vertices.add(2, new Vertex(10, 10, 10, 0, 1, 0, 1, 1, 0, 0));
        triangles.add(9, triangle);

        /* 
        The yellow side has normal vectors that point in different directions,
        which makes it appear rounded when lighting is applied. For the other
        sides all vertices have the same normal vectors, making them appear flat. 
        */

        triangle = new Triangle();
        triangle.vertices.add(0, new Vertex(-10, -10, -10, 1, 1, 0, 1, -0.577f, -0.577f, -0.577f));
        triangle.vertices.add(1, new Vertex(-10, 10, -10, 1, 1, 0, 1, -0.577f, -0.577f, -0.577f));
        triangle.vertices.add(2, new Vertex(-10, -10, 10, 1, 1, 0, 1, -0.577f, -0.577f, -0.577f));
        triangles.add(10, triangle);

        triangle = new Triangle();
        triangle.vertices.add(0, new Vertex(-10, -10, 10, 1, 1, 0, 1, -0.577f, -0.577f, -0.577f));
        triangle.vertices.add(1, new Vertex(-10, 10, 10, 1, 1, 0, 1, -0.577f, -0.577f, -0.577f));
        triangle.vertices.add(2, new Vertex(-10, 10, -10, 1, 1, 0, 1, -0.577f, -0.577f, -0.577f));
        triangles.add(11, triangle);
    }
}


/* A span describes a horizontal strip that we fill in with pixels */
class Span {

    public ArrayList<Edge> edges = new ArrayList<Edge>();

    public Edge leftEdge() {
        if (edges.get(0).x < edges.get(1).x) {
            return edges.get(0);
        } else {
            return edges.get(1);
        }
    }

    public Edge rightEdge() {
        if (edges.get(0).x > edges.get(1).x) {
            return edges.get(0);
        } else {
            return edges.get(1);
        }
    }
}


/* An edge is one side of such a horizontal strip */
class Edge {

    /* start or end coordinate */
    public float x=0;

    /* color */
    public float r=0, g=0, b=0, a=0;

    /* for checking and filling in the depth buffer */
    public float z=0;

    /* interpolated normal vector */
    public float nx=0, ny=0, nz=0;

    public Edge(float x, float r, float g, float b, float a, float z, float nx, float ny, float nz) {
        this.x = x;
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
        this.z = z;
        this.nx = nx;
        this.ny = ny;
        this.nz = nz;
    }
}


public class animation extends JPanel {
    
    // #region variables

    /* resolution */
    public static int WIDTH = 1280;
    public static int HEIGHT = 960;
    
    private BufferedImage canvas;
    private CubeModel model;

    /* background color */
    public static float background_r = 30 / 255f;
    public static float background_g = 30 / 255f;
    public static float background_b = 45 / 255f;
    public static float background_a = 1f;
    public static int BACKGROUND_COLOR = ((int) (background_a* 255) << 24) |
                                                                            ((int) (background_r * 255) << 16) |
                                                                            ((int) (background_g * 255) << 8) |
                                                                            ((int) (background_b * 255));

    /* model position */
    float modelX = 0;
    float modelY = 0;
    float modelZ = 0;

    /* model scale */
    float modelScaleX = 1;
    float modelScaleY = 1;
    float modelScaleZ = 1;

    /* model orientation */
    float modelRotateX = 0;
    float modelRotateY = 0;
    float modelRotateZ = 0;

    /* local origin */
    float modelOriginX = 10;
    float modelOriginY = 0;
    float modelOriginZ = 10;

    /* camera position */
    float cameraX = 0;
    float cameraY = 20;
    float cameraZ = -20;

    /* ambient light */
    float ambientR = 1;
    float ambientG = 1;
    float ambientB = 1;
    float ambientIntensity = 0.2f;

    /* diffuse light color */
    float diffuseR = 1;
    float diffuseG = 1;
    float diffuseB = 1;
    float diffuseIntensity = 0.8f;

    /*diffuse light direction */
    float diffuseX = 0;
    float diffuseY = 0;
    float diffuseZ = 1;

    /* depth buffer */
    boolean useDepthBuffer = true;
    float[] depthBuffer = depthBuffer();

    public float[] depthBuffer() {
        float depthBuffer[] = new float[WIDTH * HEIGHT];
        Arrays.fill(depthBuffer, 0);

        return depthBuffer;
    }

    /* there are as many spans as there are vertical lines in screenspace */
    ArrayList<Span> spans;
    int firstSpanLine = 0;
    int lastSpanLine = 0;

    /* animation */
    float bounceSpeed = 60;
    float bounceAcceleration = -60;
    float deltaTime;
    double now;
    double previousTime = 0;

    // #endregion

    
    /* Constructor to initialize the canvas and the model */
    public animation(int WIDTH, int HEIGHT) {
        canvas = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        model = new CubeModel();
        clear();
    }


    /* This method is needed to draw something on a JPanel */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }
    
    /* Paints canvas with background color */
    public void clear() {
        for (int x = 0; x < canvas.getWidth(); x++) {
            for (int y = 0; y < canvas.getHeight(); y++) {

                /* no need to call setPixel if the pixel at (x, y) coordinates already has the background color */
                if (canvas.getRGB(x, y) != BACKGROUND_COLOR) {
                    this.setPixel(x, y, background_r, background_g, background_b, background_a);
                }
            }
        }
    }
    

    /* Primitive method that changes the pixel at  (x, y) coordinates to the color (r, g, b, a). */
    public int setPixel(int x, int y, float r, float g, float b, float a) {
        /* is the pixel visible? */
        if ( x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
            
            /* convert the (r, g, b, a) values to a single int */
            int color = ((int) (a* 255) << 24) |
                                ((int) (r * 255) << 16) |
                                ((int) (g * 255) << 8) |
                                ((int) (b * 255));

            canvas.setRGB(x, y, color);

            return color;
        }
        return -1;
    }


    /* Testing method to assert the model's (x, y, z) coordinates during the rendering process */
    private void assertModelXYZ(CubeModel model, String msg) {

        System.out.println("\n" + msg);

        for (int i=0; i<12; i++) {
            for (int j=0; j<3; j++) {
                System.out.print( model.triangles.get(i).vertices.get(j).x + " ");
                System.out.print( model.triangles.get(i).vertices.get(j).y + " ");
                System.out.print( model.triangles.get(i).vertices.get(j).z + "\n");
            }
        }
    }

    int counter = 0;
    public void render() {

        /* clear screen */
        counter++;
        if (counter == 100) {
            clear(); 
            counter=0;
        }

        /* also clear depth buffer, if enabled (fill with large values) */
        if (useDepthBuffer) Arrays.fill(depthBuffer, Float.MAX_VALUE);

        /* 
        place the 3D cube in the 3D world, adjust camera viewpoint 
        and project everything to 2D triangles...
        */
        CubeModel projected = transformAndProject();
        assertModelXYZ(projected, "after transformAndProject");
        assertModelXYZ(model, "model");

        /* ...and draw these triangles on the screen. */
        for (int i=0; i<12; i++) {
            //draw(projected.triangles.get(i));

            /* use this if you want to see the vertices, not whole triangles */
            drawOnlyVertices(projected.triangles.get(i));

        }
    }


    private CubeModel transformAndProject() {
        
        Triangle newTriangle;
        Vertex newVertex;
        double tempA, tempB;
        
        CubeModel transformed = new CubeModel(model);

        assertModelXYZ(transformed, "start");

        /* first, model space to world space */
        /* look at each triangle... */
        for (int i=0; i<12; i++) {
            newTriangle = new Triangle();

            /* look at each vertex of the triangle... */
            for (int j=0; j<3; j++) {
                newVertex = transformed.triangles.get(i).vertices.get(j);

                /* we may need to adjust the model's origin */
                newVertex.x -= modelOriginX;
                newVertex.y -= modelOriginY;
                newVertex.z -= modelOriginZ;
                
                /* scale the vertex */
                newVertex.x *= modelScaleX;
                newVertex.y *= modelScaleY;
                newVertex.z *= modelScaleZ;

                /* rotate about the X-axis, this rotates the vertex around the model's adjusted origin. */
                tempA = Math.cos(modelRotateX)*newVertex.y + Math.sin(modelRotateX)*newVertex.z;
                tempB = -Math.sin(modelRotateX)*newVertex.y + Math.cos(modelRotateX)*newVertex.z;
                newVertex.y = (float) tempA;
                newVertex.z = (float) tempB;

                /* rotate about the Y-axis */
                tempA = Math.cos(modelRotateY)*newVertex.x + Math.sin(modelRotateY)*newVertex.z;
                tempB = -Math.sin(modelRotateY)*newVertex.x + Math.cos(modelRotateY)*newVertex.z;
                newVertex.x = (float) tempA;
                newVertex.z = (float) tempB;

                /* rotate about the Z-axis */
                tempA = Math.cos(modelRotateZ)*newVertex.x + Math.sin(modelRotateZ)*newVertex.y;
                tempB = -Math.sin(modelRotateZ)*newVertex.x + Math.cos(modelRotateZ)*newVertex.y;
                newVertex.x = (float) tempA;
                newVertex.y = (float) tempB;

                /* perform translation to the model's position in the 3D world */
                newVertex.x += modelX;
                newVertex.y += modelY;
                newVertex.z += modelZ;
                
                /* we also need to rotate the normal vector so that it stays aligned with the orientation of the vertex */
                /* TODO X-axis, Z-axis */
                tempA = Math.cos(modelRotateY)*newVertex.nx + Math.sin(modelRotateY)*newVertex.nz;
                tempB = -Math.sin(modelRotateY)*newVertex.nx + Math.cos(modelRotateY)*newVertex.nz;
                newVertex.nx = (float) tempA;
                newVertex.nz = (float) tempB;

                /* store the new vertex into the new triangle */
                newTriangle.vertices.set(j, newVertex);
            }
            transformed.triangles.set(i, newTriangle);
        }
        
        assertModelXYZ(transformed, "model to world");

        /* world space to camera */
        for (int i=0; i<12; i++) {
            newTriangle = new Triangle();

            for (int j=0; j<3; j++) {
                newVertex = transformed.triangles.get(i).vertices.get(j);

                /* move everything in the world opposite to the camera */
                newVertex.x -= cameraX;
                newVertex.y -= cameraY;
                newVertex.z -= cameraZ;

                /* TODO likewise, rotations can be performed */

                newTriangle.vertices.set(j, newVertex);
            }
            transformed.triangles.set(i, newTriangle);
        }

        assertModelXYZ(transformed, "world to camera");

        /* 
        At this point you may want to throw away triangles that aren't going to
        be visible anyway, for example those that are behind the camera or those
        that are facing away from the camera. (Not implemented but it involves a
        bit more math. Metal or OpenGL will automatically do this for you.)

        A common technique is backface culling. Backface culling works 
        by computing the angle between the orientation of the camera and the 
        direction the triangle is facing. This tells you if the triangle is pointing towards 
        the camera (i.e. visible) or away from it (invisible). You simply delete triangles 
        that are facing the wrong way so they won’t get processed any further.
        */

        /* final transformation step */
        /* camera space to screen space (going from 3D to 2D, i.e. getting rid of the z-axis) */
        for (int i=0; i<12; i++) {
            newTriangle = new Triangle();

            for (int j=0; j<3; j++) {
                newVertex = transformed.triangles.get(i).vertices.get(j);

                /* a simple way to do a 3D-to-2D projection is to divide both x and y by z */
                newVertex.x /= ((newVertex.z + 100) * 0.0008f);
                newVertex.y /= (newVertex.z + 100) * 0.0008f;

                /* convert our world units to pixels */
                newVertex.x += (float) (HEIGHT / 80);
                newVertex.y += (float) (HEIGHT / 80);

                /* we want (0, 0) to be in the center of the screen. Initially it is at the bottom-right corner. */
                newVertex.x += (float) (WIDTH / 2);
                newVertex.y += (float) (HEIGHT / 2);

                newTriangle.vertices.set(j, newVertex);
            }
            transformed.triangles.set(i, newTriangle);
        }

        assertModelXYZ(transformed, "camera to screen");

        if (!useDepthBuffer) {
            // TODO
        }

        return transformed;
    }


    private void drawOnlyVertices(Triangle triangle) {

        Vertex vertex;

        for (int i=0; i<3; i++) {
            vertex = triangle.vertices.get(i);
            setPixel((int) vertex.x, (int) vertex.y, vertex.r, vertex.g, vertex.b, vertex.a);
        }
    }


    private void draw(Triangle triangle) {

        /* only draw the triangle if it is at least partially inside the viewpoint */
        if (!(partiallyInsideViewport(triangle.vertices.get(0))) &&
            !(partiallyInsideViewport(triangle.vertices.get(0))) &&
            !(partiallyInsideViewport(triangle.vertices.get(0)))) {
                return;
            }

        /* reset the span so that we're starting with a clean slate */
        spans = new ArrayList<Span>();
        for (int i=0; i< HEIGHT; i++) { spans.add(new Span()); }
        firstSpanLine = Integer.MAX_VALUE;
        lastSpanLine = -1;

        /* interpolate all the things */
        addEdge(triangle.vertices.get(0), triangle.vertices.get(1));
        addEdge(triangle.vertices.get(1), triangle.vertices.get(2));
        addEdge(triangle.vertices.get(2), triangle.vertices.get(0));

        /* and finally draw the horizontal strips , this is where the fragment shader gets called */
        drawSpans();
    }


    private boolean partiallyInsideViewport(Vertex vertex) {
        return vertex.x >= 0 || vertex.x < WIDTH ||
                    vertex.y >= 0 || vertex.y < HEIGHT;
    }

    
    private void addEdge(Vertex vertex1, Vertex vertex2) {

        Vertex start, end;

        float yDiff = (float) ( Math.ceil((vertex2.y - 0.5f)) - Math.ceil((vertex1.y - 0.5f)) );

        /* degenerate edge */
        if (yDiff == 0) return;

        if (yDiff > 0) {
            start = vertex1;
            end = vertex2;
        } else {
            start = vertex2;
            end = vertex1;
        }

        float len = Math.abs(yDiff);

        /* y should be int because it needs to fit on a 1-pixel line */
        int yPos = (int) Math.ceil(start.y - 0.5);
        int yEnd = (int) Math.ceil(end.y - 0.5);

        /* x can stay float for now */
        float xStep = (end.x - start.x) / len;
        float xPos = start.x + xStep / 2;

        float zStep = (end.z - start.z) / len;
        float zPos = start.z + zStep / 2;

        float rStep = (end.r - start.r) / len;
        float rPos = start.r;

        float gStep = (end.g - start.g) / len;
        float gPos = start.g;
        
        float bStep = (end.b - start.b) / len;
        float bPos = start.b;

        float aStep = (end.a - start.a) / len;
        float aPos = start.a;

        float nxStep = (end.nx - start.nx) / len;
        float nxPos = start.nx;

        float nyStep = (end.ny - start.ny) / len;
        float nyPos = start.ny;

        float nzStep = (end.nz - start.nz) / len;
        float nzPos = start.nz;

        while (yPos < yEnd) {

            /* now we make x an int too */
            int x = (int) Math.ceil(xPos - 0.5);

            /* don't want to go outside the visible area */
            if (yPos >= 0 && yPos < HEIGHT) {
                /* this is to optimize drawSpans, so it knows where to start drawing and where to end */
                if (yPos < firstSpanLine) { firstSpanLine = yPos; }
                if (yPos > lastSpanLine) { lastSpanLine = yPos; }

                /* add this edge to the span for this line */
                spans.get(yPos).edges.add(new Edge(x, rPos, gPos, bPos, aPos, zPos, nxPos, nyPos, nzPos));
            }

            /* move the interpolations one step forward */
            yPos += 1;
            xPos += xStep;
            zPos += zStep;
            rPos += rStep;
            gPos += gStep;
            bPos += bStep;
            aPos += aStep;
            nxPos += nxStep;
            nyPos += nyStep;
            nzPos += nzStep;
        }
    }   


    private void drawSpans() {

        float x, z, r, g, b, a, nx, ny, nz;
        float step, pos, factor;
        int offset;
        boolean shouldDrawPixel;
        Edge edge1, edge2;

        if (lastSpanLine == -1) return;

        for (int y=firstSpanLine; y<=lastSpanLine; y++) {

            if (spans.get(y).edges.size() == 2) {
                edge1 = spans.get(y).leftEdge();
                edge2 = spans.get(y).rightEdge();

                /* how much to interpolate on each step */
                step = 1 / (float) (edge2.x - edge1.x);
                pos = 0;

                for (x=edge1.x; x< edge2.x; x++) {
                    /* interpolate between the colors again */
                    r = edge1.r + (edge2.r - edge1.r) * pos;
                    g = edge1.g + (edge2.g - edge1.g) * pos;
                    b = edge1.b + (edge2.b - edge1.b) * pos;
                    a = edge1.a + (edge2.a - edge1.a) * pos;

                    /* The depth buffer makes sure that a triangle that is further away
                    does not obscure a triangle that is closer to the camera. This is
                    done by storing the z-value of each triangle pixel into the depth
                    buffer. To use the depth buffer we also interpolate between these
                    z-positions to calculate the z-position each pixel corresponds with.
                    We only draw the pixel if no "nearer" pixel has yet been drawn. 
                    (This is also a feature that Metal provides for you already.) */

                    shouldDrawPixel = true;

                    if(useDepthBuffer) {
                        z = edge1.z + (edge2.z - edge1.z) * pos;
                        offset = (int) x + y * WIDTH;
                        if (depthBuffer[offset] > z) {
                            depthBuffer[offset] = z;
                        } else {
                            shouldDrawPixel = false;
                        }
                    }

                    /* also interpolate the normal vector */
                    nx = edge1.nx + (edge2.nx - edge1.nx) * pos;
                    ny = edge1.ny + (edge2.ny - edge1.ny) * pos;
                    nz = edge1.nz + (edge2.nz - edge1.nz) * pos;

                    if (shouldDrawPixel) {

                        factor = Math.min(Math.max(0, -1*(nx*diffuseX + ny*diffuseY + nz*diffuseZ)), 1);

                        r *= (ambientR*ambientIntensity + factor*diffuseR*diffuseIntensity);
                        g *= (ambientG*ambientIntensity + factor*diffuseG*diffuseIntensity);
                        b *= (ambientB*ambientIntensity + factor*diffuseB*diffuseIntensity);

                        /* clamp the colors so they don't become too bright */
                        r = Math.max(Math.min(r, 1), 0);
                        g = Math.max(Math.min(g, 1), 0);
                        b = Math.max(Math.min(b, 1), 0);

                        setPixel((int) x, y, r, g, b, a);
                    }
                }
            }
        }
    }


    private void animate() {

        now = System.nanoTime();
        deltaTime = (float) (now - previousTime);
        previousTime = now;

        /* delta time too small */
        if (deltaTime <= 0) return;

        /* delta time too large */
        if (deltaTime > 1) { deltaTime = 0.1f; }
        bounceSpeed += bounceAcceleration * deltaTime;
        modelY += bounceSpeed * deltaTime;

        if (modelY < 0) {
            /* restore position */
            modelY -= bounceSpeed * deltaTime;

            /* reverse direction */
            bounceSpeed = -bounceSpeed;
        }

        /* change the scaling of the cube based on the bounce position */
        modelScaleY = (modelY + 30) / 50;
        modelScaleX = 1.5f - modelScaleY / 2;
        modelScaleZ = modelScaleX;

        /* Add some rotations, just for the fun of it. */
        //modelRotateX += 1.8f * deltaTime;
        modelRotateY += 1.5f * deltaTime;
        modelRotateZ += 0.4f * deltaTime;

        render();
        repaint();
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("animation demo");

        animation panel = new animation(WIDTH, HEIGHT);

        JSlider camera = new JSlider(JSlider.HORIZONTAL,
                                      1, 100, 50);

        panel.setMaximumSize(new Dimension(1500, 1500));
        camera.setMaximumSize(new Dimension(1, 1));

        frame.setTitle("Animation Demo");
        frame.setLocation(new Point(100, 100));
        frame.getContentPane().add(panel);
        //frame.getContentPane().add(camera);
        //frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.pack();
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        /*for (int i=0; i<12; i++) {
            for (int j=0; j<3; j++) {
                System.out.print((int) panel.model.triangles.get(i).vertices.get(j).x + " ");
                System.out.print((int) panel.model.triangles.get(i).vertices.get(j).y + " ");
                System.out.print((int) panel.model.triangles.get(i).vertices.get(j).z + "\n");
            }
        }*/

        float r,g,b,a=1f;
        int x,y;

        float leftLimit = 0 / 255f;
        float rightLimit = 255 / 255f;

        int counter=0;;


        while(true) {

            try {
                Thread.sleep(12);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            panel.animate();
            //panel.render();
            //panel.repaint();

            /*x = (int) (new Random().nextFloat() * (WIDTH));
            y = (int) (new Random().nextFloat() * (HEIGHT));
            r = leftLimit + new Random().nextFloat() * (rightLimit - leftLimit);
            g = leftLimit + new Random().nextFloat() * (rightLimit - leftLimit);
            b = leftLimit + new Random().nextFloat() * (rightLimit - leftLimit);
            //a = leftLimit + new Random().nextFloat() * (rightLimit - leftLimit);

            /*panel.setPixel(x, y, r, g, b, a);
            panel.setPixel(x+1, y, r, g, b, a);
            panel.setPixel(x, y+1, r, g, b, a);
            panel.setPixel(x+1, y+1, r, g, b, a);
            panel.setPixel(x+2, y, r, g, b, a);
            panel.setPixel(x+2, y+1, r, g, b, a);
            panel.setPixel(x+2, y+2, r, g, b, a);
            panel.setPixel(x, y+2, r, g, b, a);
            panel.setPixel(x+1, y+2, r, g, b, a);
            panel.setPixel(x+2, y+2, r, g, b, a);*/

            /*for (int i=0; i<100; i++) {
                if (x+i < WIDTH) {
                    panel.setPixel(x+i, y, r, g, b, a);
                    panel.setPixel(x+i, y+99, r, g, b, a);

                    for (int offset=5; offset < 60; offset=offset+20) {
                        panel.setPixel(x+i+offset, y+offset, r, g, b, a);
                        panel.setPixel(x+i+offset, y+99+offset, r, g, b, a);
                    }
                }
                if (y+i < HEIGHT) {
                    panel.setPixel(x, y+i, r, g, b, a);
                    panel.setPixel(x+99, y+i, r, g, b, a);

                    for (int offset=5; offset < 60; offset=offset+10) {
                        panel.setPixel(x+offset, y+i+offset, r, g, b, a);
                        panel.setPixel(x+99+offset, y+i+offset, r, g, b, a);
                    }
                }
                /*if (x-i > 0) {
                    panel.setPixel(x-i, y, r, g, b, a);
                }
                if (y-i > 0) {
                    panel.setPixel(x, y-i, r, g, b, a);
                }*/
            /*}
            
            panel.repaint();

            counter++;

            if(counter > 150) {
                counter =0;
                panel.clear();
                panel.repaint();
            }
            

            */
        }
        
    }
}
