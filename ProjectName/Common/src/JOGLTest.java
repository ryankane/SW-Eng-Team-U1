import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2ES1;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.fixedfunc.GLLightingFunc;
import javax.media.opengl.fixedfunc.GLMatrixFunc;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.Animator;

// Imported from local libraries

public class JOGLTest implements GLEventListener, KeyListener {
	float rotateT = 0.0f;
	static GLU glu = new GLU();
	static GLCanvas canvas = new GLCanvas();
	static Frame frame = new Frame("Jogl Quad drawing");
	static Animator animator = new Animator(canvas);

	// 16-Color Palette
	private final Color MAROON = new Color(128, 0, 0);
	private final Color RED = new Color(255, 0, 0);
	private final Color ORANGE = new Color(255, 165, 0);
	private final Color YELLOW = new Color(255, 255, 0);
	private final Color OLIVE = new Color(128, 128, 0);
	private final Color GREEN = new Color(0, 128, 0);
	private final Color LIME = new Color(0, 255, 0);
	private final Color TEAL = new Color(0, 128, 128);
	private final Color CYAN = new Color(0, 255, 255);
	private final Color BLUE = new Color(0, 0, 255);
	private final Color NAVY = new Color(0, 0, 128);
	private final Color PURPLE = new Color(128, 0, 128);
	private final Color FUCHSIA = new Color(255, 0, 255);
	private final Color WHITE = new Color(255, 255, 255);
	private final Color SILVER = new Color(192, 192, 192);
	private final Color BLACK = new Color(0, 0, 0);

	public JOGLTest() {

	}

	// Going to try a sphere. Check out [http://www.land-of-kain.de/docs/jogl/]
	// for an awesome example.
	// More Examples:
	// http://www.felixgers.de/teaching/jogl/
	// http://www.falloutsoftware.com/tutorials/gl/gl3.htm
	// http://www.java-tips.org/other-api-tips/jogl/introduction-to-jogl.html
	

	public void drawTriangle(GL2 gl2, Point p1, Point p2, Point p3, Color color) {
		final GL2 gl = gl2.getGL().getGL2();
		gl.glBegin(GL2.GL_TRIANGLES); // Begin Drawing
		gl.glColor3f((float) (color.getRed() / 255f),
				(float) (color.getGreen() / 255f),
				(float) (color.getBlue() / 255f));
		gl.glVertex3f((float) p1.getX(), (float) p1.getY(), (float) p1.getZ());
		gl.glVertex3f((float) p2.getX(), (float) p2.getY(), (float) p2.getZ());
		gl.glVertex3f((float) p3.getX(), (float) p3.getY(), (float) p3.getZ());
		gl.glEnd(); // Done Drawing
	}

	public void drawSquare(GL2 gl2, Point p1, Point p2, Point p3, Point p4,
			Color color) {
		final GL2 gl = gl2.getGL().getGL2();
		gl.glBegin(GL2.GL_QUADS); // Begin Drawing
		gl.glColor3f((float) (color.getRed() / 255f),
				(float) (color.getGreen() / 255f),
				(float) (color.getBlue() / 255f));
		gl.glVertex3f((float) p1.getX(), (float) p1.getY(), (float) p1.getZ());
		gl.glVertex3f((float) p2.getX(), (float) p2.getY(), (float) p2.getZ());
		gl.glVertex3f((float) p3.getX(), (float) p3.getY(), (float) p3.getZ());
		gl.glVertex3f((float) p4.getX(), (float) p4.getY(), (float) p4.getZ());
		gl.glEnd(); // Done Drawing
	}
	
	public void drawHexagon(GL2 gl2, Point p1, Point p2, Point p3, Point p4, 
			Point p5, Point p6, Point p7, Point p8, Color color){
		final GL2 gl = gl2.getGL().getGL2();
		gl.glBegin(GL2.GL_TRIANGLE_FAN); // Begin Drawing
		gl.glColor3f((float) (color.getRed() / 255f),
				(float) (color.getGreen() / 255f),
				(float) (color.getBlue() / 255f));
		gl.glVertex3f((float) p1.getX(), (float) p1.getY(), (float) p1.getZ());
		gl.glVertex3f((float) p2.getX(), (float) p2.getY(), (float) p2.getZ());
		gl.glVertex3f((float) p3.getX(), (float) p3.getY(), (float) p3.getZ());
		gl.glVertex3f((float) p4.getX(), (float) p4.getY(), (float) p4.getZ());
		gl.glVertex3f((float) p5.getX(), (float) p5.getY(), (float) p5.getZ());
		gl.glVertex3f((float) p6.getX(), (float) p6.getY(), (float) p6.getZ());
		gl.glVertex3f((float) p7.getX(), (float) p7.getY(), (float) p7.getZ());
		gl.glVertex3f((float) p8.getX(), (float) p8.getY(), (float) p8.getZ());
		gl.glEnd(); 		
	}
	

	public void display(GLAutoDrawable gLDrawable) {
		final GL2 gl = gLDrawable.getGL().getGL2();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glClear(GL.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		gl.glTranslatef(0.0f, 0.0f, -5.0f);

		// rotate on the three axis

		//gl.glRotatef(rotateT, 0.0f, 1.0f, 0.0f); // y - pitch
		//gl.glRotatef(rotateT, 0.0f, 0.0f, 1.0f); // z - yaw
		gl.glRotatef(rotateT, 1.0f, 0.0f, 0.0f); // x - roll

		// Awesome! [http://www.falloutsoftware.com/tutorials/gl/gl3.htm] -Ryan

		// Draw a Square Pyramid
		Point top = new Point(0.0, 0.0, 3.0);
		Point q1 = new Point(1.0, 1.0, 0.0);
		Point q2 = new Point(-1.0, 1.0, 0.0);
		Point q3 = new Point(-1.0, -1.0, 0.0);
		Point q4 = new Point(1.0, -1.0, 0.0);
		drawSquare(gl, q1, q2, q3, q4, PURPLE);
		drawTriangle(gl, q1, q2, top, NAVY);
		drawTriangle(gl, q2, q3, top, CYAN);
		drawTriangle(gl, q3, q4, top, TEAL);
		drawTriangle(gl, q4, q1, top, BLUE);
		
		// Draw a Sphere 
		// This looks promising -- http://www.java-tips.org/other-api-tips/jogl/sphere-mapping-quadrics-in-opengl-nehe-tutorial-jogl-2.html

		// Where is the Vertex? How do I move it...
		GLUquadric qobj0 = glu.gluNewQuadric();
		gl.glColor3f( 0f, 1f, 0f );
		gl.glEnable(GL2.GL_LIGHT0);
		//gl.glEnable(GL2.GL_LIGHTING);
		glu.gluSphere(qobj0, 1.0, 50, 20);

		// increasing rotation for the next iteration
		
		// Draw a Trapazoidal Cube
		Point b_q1 = new Point(3.0, 3.0, -1.0);
		Point b_q2 = new Point(3.0, 2.0, -1.0);
		Point b_q3 = new Point(2.0, 2.0, -1.0);
		Point b_q4 = new Point(2.0, 3.0, -1.0);
		Point t_q1 = new Point(2.75, 2.75, 1.0);
		Point t_q2 = new Point(2.75, 2.25, 1.0);
		Point t_q3 = new Point(2.25, 2.25, 1.0);
		Point t_q4 = new Point(2.25, 2.75, 1.0);
		drawSquare(gl, b_q1, b_q2, b_q3, b_q4, WHITE);
		drawSquare(gl, t_q1, t_q2, b_q2, b_q1, RED);
		drawSquare(gl, t_q2, t_q3, b_q3, b_q2, YELLOW);
		drawSquare(gl, t_q3, t_q4, b_q4, b_q3, GREEN);
		drawSquare(gl, t_q4, t_q1, b_q1, b_q4, CYAN);
		drawSquare(gl, t_q1, t_q2, t_q3, t_q4, FUCHSIA);

		// Draw a Hexagonal Prism
		Point h_0 = new Point(-2.5, -2.5, 0.0);
		Point h_1 = new Point(-3.0, -3.0, 0.0);
		Point h_2 = new Point(-2.0, -3.0, 0.0);
		Point h_3 = new Point(-1.5, -2.5, 0.0);
		Point h_4 = new Point(-2.0, -2.0, 0.0);
		Point h_5 = new Point(-3.0, -2.0, 0.0);
		Point h_6 = new Point(-3.5, -2.5, 0.0);
		Point hb_0 = new Point(-2.5, -2.5, 1.0);
		Point hb_1 = new Point(-3.0, -3.0, 1.0);
		Point hb_2 = new Point(-2.0, -3.0, 1.0);
		Point hb_3 = new Point(-1.5, -2.5, 1.0);
		Point hb_4 = new Point(-2.0, -2.0, 1.0);
		Point hb_5 = new Point(-3.0, -2.0, 1.0);
		Point hb_6 = new Point(-3.5, -2.5, 1.0);
		drawSquare(gl, h_1, h_2, hb_2, hb_1, RED);
		drawSquare(gl, h_2, h_3, hb_3, hb_2, ORANGE);
		drawSquare(gl, h_3, h_4, hb_4, hb_3, YELLOW);
		drawSquare(gl, h_4, h_5, hb_5, hb_4, LIME);
		drawSquare(gl, h_5, h_6, hb_6, hb_5, BLUE);
		drawSquare(gl, h_6, h_1, hb_1, hb_6, FUCHSIA);
		drawHexagon(gl, h_0, h_1, h_2, h_3, h_4, h_5, h_6, h_1, WHITE);
		drawHexagon(gl, hb_0, hb_1, hb_2, hb_3, hb_4, hb_5, hb_6, hb_1, GREEN);
		
		/**
		 * // Draw Triangles gl.glBegin(GL2.GL_TRIANGLES); // Begin Larger
		 * Triangle gl.glVertex3f(-1.0f, -0.5f, -4.0f); // Lower left vertex
		 * gl.glColor3f(1.0f, 0.0f, 0.0f); // Red gl.glVertex3f(1.0f, -0.5f,
		 * -4.0f); // Lower right vertex gl.glColor3f(0.0f, 1.0f, 0.0f); //
		 * Green gl.glVertex3f(0.0f, 0.5f, -4.0f); // Upper vertex
		 * gl.glColor3f(1.0f, 0.0f, 1.0f); // Magenta gl.glEnd(); // Done
		 * Drawing Larger Triangle
		 * 
		 * gl.glBegin(GL2.GL_TRIANGLES); // Begin Smaller Triangle
		 * gl.glVertex3f(-0.5f, -1.5f, -4.0f); // Lower left vertex
		 * gl.glColor3f(1.0f, 1.0f, 0.0f); // Yellow gl.glVertex3f(0.5f, -1.5f,
		 * -4.0f); // Lower right vertex gl.glColor3f(0.0f, 1.0f, 1.0f); // Cyan
		 * gl.glVertex3f(0.0f, -1.0f, -4.0f); // Upper vertex gl.glColor3f(0.0f,
		 * 0.0f, 1.0f); // Blue gl.glEnd(); // Done Drawing Smaller Triangle
		 * 
		 * // Draw A Quad gl.glBegin(GL2.GL_QUADS); gl.glVertex3f(-0.5f, 0.5f,
		 * 0.0f); // Top Left gl.glColor3f(1.0f, 0.0f, 0.0f); // Red
		 * gl.glVertex3f(0.5f, 0.5f, 0.0f); // Top Right gl.glColor3f(1.0f,
		 * 1.0f, 0.0f); // Yellow gl.glVertex3f(0.5f, -0.5f, 0.0f); // Bottom
		 * Right gl.glColor3f(0.0f, 1.0f, 0.0f); // Green gl.glVertex3f(-0.5f,
		 * -0.5f, 0.0f); // Bottom Left gl.glColor3f(0.0f, 0.0f, 1.0f); // Blue
		 * gl.glEnd(); // Done Drawing The Quad
		 */
		// increasing rotation for the next iteration
		rotateT += 0.2f;
	}

	public void displayChanged(GLAutoDrawable gLDrawable, boolean modeChanged,
			boolean deviceChanged) {
	}

	public void init(GLAutoDrawable gLDrawable) {
		GL2 gl = gLDrawable.getGL().getGL2();
		gl.glShadeModel(GLLightingFunc.GL_SMOOTH);
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		gl.glClearDepth(1.0f);
		gl.glEnable(GL.GL_DEPTH_TEST);
		gl.glDepthFunc(GL.GL_LEQUAL);
		gl.glHint(GL2ES1.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
		((Component) gLDrawable).addKeyListener(this);
	}

	public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width,
			int height) {
		GL2 gl = gLDrawable.getGL().getGL2();
		if (height <= 0) {
			height = 1;
		}
		float h = (float) width / (float) height;
		gl.glMatrixMode(GLMatrixFunc.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluPerspective(100.0f, h, 1.0, 1000.0);
		gl.glMatrixMode(GLMatrixFunc.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

	public void keyPressed(KeyEvent e) {
		// Exit Program
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			exit();
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
		// Increase Rotation speed
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rotateT += 200f;
		}
		// Decrease Rotation speed
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rotateT -= 200f;
		}
	}

	public static void exit() {
		animator.stop();
		frame.dispose();
		System.exit(0);
	}

	public static void main(String[] args) {
		canvas.addGLEventListener(new JOGLTest());
		frame.add(canvas);
		frame.setSize(640, 480);
		frame.setUndecorated(true);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		frame.setVisible(true);
		animator.start();
		canvas.requestFocus();

	}

	public void dispose(GLAutoDrawable gLDrawable) {
		// do nothing
	}
}